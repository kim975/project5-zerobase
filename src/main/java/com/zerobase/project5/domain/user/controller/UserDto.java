package com.zerobase.project5.domain.user.controller;

import com.zerobase.project5.domain.user.service.UserCommand;
import com.zerobase.project5.domain.user.service.UserInfo;
import lombok.Builder;
import lombok.Data;

public class UserDto {

    @Data
    public static class RegisterUserRequest {
        private Long userIncomeAmount;
        private String userName;
        private String userRegistrationNumber;

        public UserCommand.UserInfoRequest toRegisterUserRequest() {
            return UserCommand.UserInfoRequest.builder()
                    .userIncomeAmount(userIncomeAmount)
                    .userName(userName)
                    .userRegistrationNumber(userRegistrationNumber)
                    .build();
        }
    }

    @Data
    @Builder
    public static class RegisterUserResponse {
        private String userKey;

        public static RegisterUserResponse of(String userKey) {
            return RegisterUserResponse.builder()
                    .userKey(userKey)
                    .build();
        }
    }


    @Data
    @Builder
    public static class UserInfoResponse {
        private String userName;
        private String userRegistrationNumber;

        public static UserInfoResponse of(UserInfo userInfo) {
            return UserInfoResponse.builder()
                    .userName(userInfo.getUsrNm())
                    .userRegistrationNumber(userInfo.getUsrRegNum())
                    .build();
        }
    }

}
