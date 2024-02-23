package com.example.recruitmentservice.api.controller;

import com.example.recruitmentservice.api.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractResponseController {
    public <T>ResponseEntity<ApiResponse<T>> responseEntity(CallbackFunction<T> callback, Integer statusCode, boolean isCreated) {
        T result = callback.execute();
        ApiResponse<T> response = new ApiResponse<>();
        response.setErrorCode(0);
        response.setStatusCode(statusCode);
        response.setObject(result);
        response.setMessage("Successful");
        HttpStatus status = HttpStatus.OK;
        if(isCreated) {
            response.setObject(null);
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(response, status);
    }
}
