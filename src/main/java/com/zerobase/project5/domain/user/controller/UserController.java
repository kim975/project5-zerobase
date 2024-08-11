package com.zerobase.project5.domain.user.controller;

import com.zerobase.project5.common.response.CommonResponse;
import com.zerobase.project5.domain.user.service.UserInfo;
import com.zerobase.project5.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fintech/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/private-info/{userKey}")
    public CommonResponse<UserDto.UserInfoResponse> searchUserPrivateInfo(
            @PathVariable("userKey") String userKey
    ) {
        UserInfo userInfo = userService.getUser(userKey);
        return CommonResponse.success(UserDto.UserInfoResponse.of(userInfo));
    }

    @PostMapping("/information")
    public CommonResponse<UserDto.RegisterUserResponse> searchUserInfo(
        @RequestBody UserDto.RegisterUserRequest request
    ) {
        String userKey = userService.registerUser(request.toRegisterUserRequest());
        return CommonResponse.success(UserDto.RegisterUserResponse.of(userKey));
    }
}
