package dev.ikhtiyor.appsharelinkserver.controller;

import dev.ikhtiyor.appsharelinkserver.entity.User;
import dev.ikhtiyor.appsharelinkserver.payload.ApiResponse;
import dev.ikhtiyor.appsharelinkserver.payload.LinkDto;
import dev.ikhtiyor.appsharelinkserver.security.CurrentUser;
import dev.ikhtiyor.appsharelinkserver.service.LinkService;
import dev.ikhtiyor.appsharelinkserver.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ikhtiyor Khaitov
 * 16/05/21
 **/

@RestController
@RequestMapping("/api/link")
public class LinkController {

    @Autowired
    LinkService linkService;

    @PostMapping("/add")
    public HttpEntity<?> addLink(
            @CurrentUser User user,
            @RequestBody LinkDto request) {
        ApiResponse apiResponse = linkService.addLink(request, user);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> editLink(
            @PathVariable long id,
            @CurrentUser User user,
            @RequestBody LinkDto request) {
        ApiResponse apiResponse = linkService.editLink(id, request, user);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteLink(
            @PathVariable long id
    ) {
        ApiResponse apiResponse = linkService.deleteLink(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PostMapping("/get")
    public HttpEntity<?> getOneLink(
            @RequestBody LinkDto request
    ) {
        ApiResponse apiResponse = linkService.getOneLink(request);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getAllLinks(
            @RequestParam(name = "page", defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(name = "size", defaultValue = Constants.DEFAULT_SIZE) int size
    ) {
        ApiResponse allLinks = linkService.getAllLinks(page, size);
        return ResponseEntity.ok(allLinks);
    }

}
