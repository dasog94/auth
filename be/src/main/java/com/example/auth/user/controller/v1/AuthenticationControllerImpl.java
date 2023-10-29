package com.example.auth.user.controller.v1;

import com.example.auth.user.controller.AuthenticationController;
import com.example.auth.user.controller.dto.LogoutInfoDTO;
import com.example.auth.user.controller.dto.in.LoginDTO;
import com.example.auth.user.controller.dto.out.LoginInfoDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/auth/v1")
@Controller
public class AuthenticationControllerImpl implements AuthenticationController {

    @Override
    @PostMapping("/login")
    public ResponseEntity<LoginInfoDTO> login(HttpServletRequest request, @RequestBody LoginDTO loginDTO) {
        log.info(loginDTO.toString());
        request.getSession();

        return ResponseEntity.ok(LoginInfoDTO.builder()
                .result("welcome")
                .build()
        );
    }

    @Override
    public ResponseEntity<LogoutInfoDTO> logout(HttpServletRequest request) {
        if (request.isRequestedSessionIdValid()) {
            HttpSession session = request.getSession();
            session.invalidate();
        }
        return ResponseEntity.ok(LogoutInfoDTO.builder()
                .result("logout")
                .build()
        );
    }
}