package com.zerobase.project5.domain.user.service;

public interface UserService {
    String registerUser(UserCommand.UserInfoRequest request);

    UserInfo getUser(String userKey);
}
