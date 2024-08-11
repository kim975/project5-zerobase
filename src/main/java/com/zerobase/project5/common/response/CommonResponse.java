package com.zerobase.project5.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonResponse<T> {

    private final static String SUCCESS_CODE = "00";
    private final static String SUCCESS_MESSAGE = "success";
    private final static String SUCCESS_DEFAULT_DATA = "ok";

    private T data;
    private String responseCode;
    private String responseMessage;

    public static <T> CommonResponse<T> success(T data) {
        return (CommonResponse<T>) CommonResponse.builder()
                .data(data)
                .responseCode(SUCCESS_CODE)
                .responseMessage(SUCCESS_MESSAGE)
                .build();
    }

    public static <T> CommonResponse<T> success() {
        return (CommonResponse<T>) CommonResponse.builder()
                .data(SUCCESS_DEFAULT_DATA)
                .responseCode(SUCCESS_CODE)
                .responseMessage(SUCCESS_MESSAGE)
                .build();
    }

    public static <T> CommonResponse<T> fail(ErrorCode errorCode) {
        return (CommonResponse<T>) CommonResponse.builder()
                .responseCode(errorCode.getErrorCode())
                .responseMessage(errorCode.getErrorMessage())
                .build();
    }

}
