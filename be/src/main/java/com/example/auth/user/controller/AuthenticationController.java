package com.example.auth.user.controller;

import com.example.auth.user.controller.dto.LogoutInfoDTO;
import com.example.auth.user.controller.dto.in.LoginDTO;
import com.example.auth.user.controller.dto.out.LoginInfoDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationController {
    ResponseEntity<LoginInfoDTO> login(HttpServletRequest request, LoginDTO loginDTO);

    ResponseEntity<LogoutInfoDTO> logout(HttpServletRequest request);
}
