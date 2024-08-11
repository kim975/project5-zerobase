package com.zerobase.project5.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    INTERNAL_SYSTEM_ERROR("E00001", "시스템 오류가 발생 했습니다."),
    COMMON_BUSINESS_ERROR("E00002", "비즈니스 오류가 발생했습니다."),
    COMMON_INVALID_PARAMETER("E00003", "요청한 값이 올바르지 않습니다.");

    private final String errorCode;
    private final String errorMessage;

}
