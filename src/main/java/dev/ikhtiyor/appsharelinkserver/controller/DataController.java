package dev.ikhtiyor.appsharelinkserver.controller;

import dev.ikhtiyor.appsharelinkserver.entity.DataEntity;
import dev.ikhtiyor.appsharelinkserver.payload.ApiResponse;
import dev.ikhtiyor.appsharelinkserver.service.DataService;
import dev.ikhtiyor.appsharelinkserver.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    DataService dataService;

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteLink(@PathVariable UUID id) {
        ApiResponse apiResponse = dataService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @GetMapping("/get/{id}")
    public HttpEntity<?> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(dataService.getOne(id));
    }

    @GetMapping
    public HttpEntity<?> getAllLinks(@RequestParam(name = "page", defaultValue = Constants.DEFAULT_PAGE) int page, @RequestParam(name = "size", defaultValue = Constants.DEFAULT_SIZE) int size) {
        ApiResponse allLinks = dataService.getAllData(page, size);
        return ResponseEntity.ok(allLinks);
    }

    @PostMapping("/save")
    public HttpEntity<?> addLink(@RequestBody DataEntity dataEntity) {
        ApiResponse apiResponse = dataService.save(dataEntity);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).
                body(apiResponse);
    }
}
