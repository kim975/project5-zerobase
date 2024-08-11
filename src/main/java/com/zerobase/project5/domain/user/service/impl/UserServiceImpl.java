package com.zerobase.project5.domain.user.service.impl;

import com.zerobase.project5.common.exception.InvalidParamException;
import com.zerobase.project5.domain.user.domain.User;
import com.zerobase.project5.domain.user.repository.UserRepository;
import com.zerobase.project5.domain.user.service.UserCommand;
import com.zerobase.project5.domain.user.service.UserInfo;
import com.zerobase.project5.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String registerUser(UserCommand.UserInfoRequest request) {
        String userKey = UUID.randomUUID().toString().replaceAll("-", "");
        User user = userRepository.save(request.toEntity(userKey));
        return user.getUsrKey();
    }

    @Override
    public UserInfo getUser(String userKey) {
        User user = userRepository.findByUsrKey(userKey)
                .orElseThrow(InvalidParamException::new);

        return UserInfo.of(user);
    }

}
