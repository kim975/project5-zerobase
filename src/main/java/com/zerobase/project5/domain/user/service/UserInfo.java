package com.zerobase.project5.domain.user.service;

import com.zerobase.project5.domain.user.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfo {

    private String usrKey;
    private String usrRegNum;
    private String usrNm;
    private Long usrIcmAmt;

    public static UserInfo of(User user) {
        return UserInfo.builder()
                .usrKey(user.getUsrKey())
                .usrRegNum(user.getUsrRegNum())
                .usrNm(user.getUsrNm())
                .usrIcmAmt(user.getUsrIcmAmt())
                .build();
    }

}
