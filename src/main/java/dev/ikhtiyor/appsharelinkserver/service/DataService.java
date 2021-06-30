package dev.ikhtiyor.appsharelinkserver.service;

import dev.ikhtiyor.appsharelinkserver.entity.DataEntity;
import dev.ikhtiyor.appsharelinkserver.payload.ApiResponse;
import dev.ikhtiyor.appsharelinkserver.repository.DataRepository;
import dev.ikhtiyor.appsharelinkserver.utils.Constants;
import dev.ikhtiyor.appsharelinkserver.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DataService {

    @Autowired
    DataRepository dataRepository;


    public DataEntity getOne(UUID id){
        return dataRepository.findById(id).get();
    }

    public ApiResponse save(DataEntity dataEntity) {
        try {
            dataRepository.save(dataEntity);
            return ResponseUtils.success("saved");
        } catch (Exception e) {
            return ResponseUtils.error(Constants.SYSTEM_ERROR);
        }

    }

    public ApiResponse delete(UUID id) {
        try {
            dataRepository.deleteById(id);
            return ResponseUtils.success("saved");
        } catch (Exception e) {
            return ResponseUtils.error(Constants.SYSTEM_ERROR);
        }

    }

    public ApiResponse getAllData(int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size, Sort.by("registerAt").descending());
            Page<DataEntity> dataEntities = dataRepository.findAll(pageRequest);
            return ResponseUtils.successPageable(
                    page,
                    size,
                    dataEntities.getTotalPages(),
                    dataEntities.getTotalElements(),
                    dataEntities.getContent()

            );
        } catch (Exception e) {
            return ResponseUtils.errorPageable();
        }
    }
}
