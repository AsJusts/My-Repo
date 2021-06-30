package dev.ikhtiyor.appsharelinkserver.payload;

import lombok.Data;

/**
 * Created by Ikhtiyor Khaitov
 * 16/05/21
 **/

@Data
public class ApiResponse {

    private String message;
    private boolean success;

    private Integer page;
    private Integer size;

    private Integer totalPages;
    private Long totalElements;

    private Object object;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(String message, boolean success, Object object) {
        this.message = message;
        this.success = success;
        this.object = object;
    }

    public ApiResponse(Object object) {
        this.object = object;
    }

    public ApiResponse(boolean success, Object object) {
        this.success = success;
        this.object = object;
    }

    public ApiResponse(boolean success) {
        this.success = success;
    }

    public ApiResponse(Integer page, Integer size, Integer totalPages, Long totalElements, Object object) {
        this.page = page;
        this.size = size;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.object = object;
    }

}
