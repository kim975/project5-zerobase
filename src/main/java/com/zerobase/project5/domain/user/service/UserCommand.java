package com.zerobase.project5.domain.user.service;

import com.zerobase.project5.domain.user.domain.User;
import lombok.Builder;
import lombok.Data;

public class UserCommand {

    @Data
    @Builder
    public static class UserInfoRequest {

        private Long userIncomeAmount;
        private String userName;
        private String userRegistrationNumber;

        public User toEntity(String userKey) {
            return User.builder()
                    .usrNm(userName)
                    .usrIcmAmt(userIncomeAmount)
                    .usrRegNum(userRegistrationNumber)
                    .usrKey(userKey)
                    .build();
        }

    }

}
