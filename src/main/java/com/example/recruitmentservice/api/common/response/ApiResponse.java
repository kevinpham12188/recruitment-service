package com.example.recruitmentservice.api.common.response;

import com.example.recruitmentservice.api.common.errorcoe.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private Integer errorCode;
    private Integer statusCode;
    private String message;
    private T object;

    public static <T> ApiResponse<T> sucess(T object) {
        return ApiResponse.<T>builder()
                .errorCode(ErrorCode.SUCCESS)
                .statusCode(HttpStatus.OK.value())
                .object(object)
                .build();
    }

    public static <T> ApiResponse<T> error(Integer errorCode, HttpStatus httpStatus, String message) {
        return ApiResponse.<T>builder()
                .errorCode(errorCode)
                .statusCode(httpStatus.value())
                .message(message)
                .build();
    }

}
