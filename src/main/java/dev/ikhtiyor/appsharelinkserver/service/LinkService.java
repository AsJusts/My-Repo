package dev.ikhtiyor.appsharelinkserver.service;

import dev.ikhtiyor.appsharelinkserver.entity.Link;
import dev.ikhtiyor.appsharelinkserver.entity.User;
import dev.ikhtiyor.appsharelinkserver.payload.ApiResponse;
import dev.ikhtiyor.appsharelinkserver.payload.LinkDto;
import dev.ikhtiyor.appsharelinkserver.repository.LinkRepository;
import dev.ikhtiyor.appsharelinkserver.utils.Constants;
import dev.ikhtiyor.appsharelinkserver.utils.ResponseUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Ikhtiyor Khaitov
 * 16/05/21
 **/

@Service
public class LinkService {

    final
    LinkRepository linkRepository;

    final
    CheckRole checkRole;

    public LinkService(LinkRepository linkRepository, CheckRole checkRole) {
        this.linkRepository = linkRepository;
        this.checkRole = checkRole;
    }

    public ApiResponse addLink(LinkDto request, User user) {
        if (checkRole.isAdmin(user)) {
            String fullUrl = Constants.LOCALHOST_API + "/file/";
            String generatedUrl = "";
            try {
                Link newLink = new Link();
                newLink.setName(request.getName());
                newLink.setOriginalLink(request.getOriginalLink());
                newLink.setDate(new Date());

                if (request.getGeneratedLink() == null || request.getGeneratedLink().length() <= 0) {
                    final int generatedUrlLength = 45;
                    generatedUrl = Constants.generateUrl(generatedUrlLength);
                } else {
                    generatedUrl = request.getGeneratedLink();
                }
                fullUrl = fullUrl + UUID.randomUUID() + "-" + generatedUrl;
                newLink.setGeneratedLink(fullUrl);

                linkRepository.save(newLink);

                return ResponseUtils.success(Constants.SUCCESS_ADD);
            } catch (Exception e) {
                return ResponseUtils.error(Constants.SYSTEM_ERROR);
            }
        } else {
            return ResponseUtils.error(Constants.NOT_PERMISSION);
        }
    }

    public ApiResponse editLink(Long id, LinkDto request, User user) {
        if (checkRole.isAdmin(user)) {
            String fullUrl = Constants.LOCALHOST_API + "/file/";
            String generatedUrl = "";
            try {
                Optional<Link> optionalLink = linkRepository.findById(id);
                if (optionalLink.isPresent()) {
                    Link foundedLink = optionalLink.get();

                    foundedLink.setName(request.getName() == null ? foundedLink.getName() : request.getName());
                    foundedLink.setOriginalLink(request.getOriginalLink() == null ? foundedLink.getOriginalLink() : request.getOriginalLink());

                    if (!(request.getOriginalLink().equals(foundedLink.getOriginalLink()))) {
                        if (request.getGeneratedLink() != null) {
                            generatedUrl = request.getGeneratedLink();
                        } else {
                            final int generatedUrlLength = 45;
                            generatedUrl = Constants.generateUrl(generatedUrlLength);
                        }
                        fullUrl = fullUrl + UUID.randomUUID() + "-" + generatedUrl;
                        foundedLink.setGeneratedLink(fullUrl);
                    }
                    linkRepository.save(foundedLink);

                    return ResponseUtils.success(Constants.SUCCESS_EDIT);

                } else {
                    return ResponseUtils.error(Constants.LINK_NOT_FOUND);
                }
            } catch (Exception e) {
                return ResponseUtils.error(Constants.SYSTEM_ERROR);
            }
        } else {
            return ResponseUtils.error(Constants.NOT_PERMISSION);
        }
    }

    public ApiResponse deleteLink(Long id) {
        try {
            linkRepository.deleteById(id);
            return ResponseUtils.success(Constants.SUCCESS_DELETE);
        } catch (Exception e) {
            return ResponseUtils.error(Constants.SYSTEM_ERROR);
        }
    }

    public ApiResponse getAllLinks(int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
            Page<Link> linkPage = linkRepository.findAll(pageRequest);

            return ResponseUtils.successPageable(
                    page,
                    size,
                    linkPage.getTotalPages(),
                    linkPage.getTotalElements(),
                    getLinkDtoList(linkPage.getContent())
            );
        } catch (Exception e) {
            return ResponseUtils.errorPageable();
        }
    }

    public List<LinkDto> getLinkDtoList(List<Link> linkPage) {
        List<LinkDto> linkDtoList = new ArrayList<>();
        for (Link link : linkPage) {
            linkDtoList.add(getLinkDto(link));
        }
        return linkDtoList;
    }

    public LinkDto getLinkDto(Link link) {
        return new LinkDto(
                link.getId(),
                link.getDate(),
                link.getName(),
                link.getOriginalLink(),
                link.getGeneratedLink()
        );
    }

    public ApiResponse getOneLink(LinkDto request) {
        try {
            Optional<Link> optionalLink = linkRepository.findByGeneratedLink(request.getGeneratedLink());
            if (optionalLink.isPresent()) {
                return ResponseUtils.success(optionalLink.get());
            } else {
                return ResponseUtils.error(Constants.LINK_NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseUtils.error(Constants.LINK_NOT_FOUND);
        }
    }
}
