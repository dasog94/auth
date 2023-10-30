package com.example.auth.user.service.v1;

import com.example.auth.user.service.AuthenticationService;
import com.example.auth.user.controller.dto.in.LoginDTO;
import com.example.auth.user.model.User;
import com.example.auth.user.model.UserLogin;
import com.example.auth.user.repository.UserLoginRepository;
import com.example.auth.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AuthenticationServiceImpl implements AuthenticationService {

    private final UserLoginRepository userLoginRepository;
    private final UserRepository userRepository;

    @Override
    public User login(LoginDTO loginDTO) {
        UserLogin userLogin = userLoginRepository.findUserLoginByUserId(loginDTO.getId())
                .orElseThrow(() -> new RuntimeException("적합한 계정이 존재하지 않습니다."));

        if (!StringUtils.equals(userLogin.getPassword(), loginDTO.getPassword())) {
            throw new RuntimeException("틀린 비밀번호입니다.");
        }

        return userRepository.findUserByUserId(userLogin.getUserId())
                .orElseThrow(() -> new RuntimeException("적합한 계정이 존재하지 않습니다."));
    }
}
