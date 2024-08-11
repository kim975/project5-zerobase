package com.zerobase.project5.domain.user.controller;

import com.zerobase.project5.common.response.CommonResponse;
import com.zerobase.project5.domain.user.service.UserInfo;
import com.zerobase.project5.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fintech/v1/user")
//@Tag(name = "", description = "상품 정보 API")
public class UserController {

    private final UserService userService;

    @Operation(summary = "유저 정보 조회 API")
    @GetMapping("/private-info/{userKey}")
    public CommonResponse<UserDto.UserInfoResponse> searchUserPrivateInfo(
            @PathVariable("userKey") String userKey
    ) {
        UserInfo userInfo = userService.getUser(userKey);
        return CommonResponse.success(UserDto.UserInfoResponse.of(userInfo));
    }

    @Operation(summary = "유저 정보 조회 API", description = "우저 정보 조회 API 이다.")
    @PostMapping("/information")
    public CommonResponse<UserDto.RegisterUserResponse> registerUserInfo(
        @RequestBody UserDto.RegisterUserRequest request
    ) {
        String userKey = userService.registerUser(request.toRegisterUserRequest());
        return CommonResponse.success(UserDto.RegisterUserResponse.of(userKey));
    }
}
