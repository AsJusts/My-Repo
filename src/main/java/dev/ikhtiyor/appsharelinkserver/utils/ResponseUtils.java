package dev.ikhtiyor.appsharelinkserver.utils;

import dev.ikhtiyor.appsharelinkserver.payload.ApiResponse;

/**
 * Created by Ikhtiyor Khaitov
 * 16/05/21
 **/

public class ResponseUtils {

    public static ApiResponse success(String message, Object object) {
        return new ApiResponse(message, true, object);
    }

    public static ApiResponse success(String message) {
        return new ApiResponse(message, true);
    }

    public static ApiResponse success(Object object) {
        return new ApiResponse(true, object);
    }

    public static ApiResponse error(String message) {
        return new ApiResponse(message, false);
    }

    public static ApiResponse error() {
        return new ApiResponse(false);
    }

    public static ApiResponse successPageable(int page, int size, int totalPage, long totalElements, Object obj) {
        return new ApiResponse(
                page,
                size,
                totalPage,
                totalElements,
                obj
        );
    }

    public static ApiResponse errorPageable() {
        int[] arr = {};
        return new ApiResponse(
                0,
                0,
                0,
                0L,
                arr
        );
    }
}
