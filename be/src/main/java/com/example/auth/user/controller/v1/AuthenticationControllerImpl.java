package com.example.auth.user.controller.v1;

import com.example.auth.user.model.User;
import com.example.auth.user.service.AuthenticationService;
import com.example.auth.user.controller.AuthenticationController;
import com.example.auth.user.controller.dto.LogoutInfoDTO;
import com.example.auth.user.controller.dto.in.LoginDTO;
import com.example.auth.user.controller.dto.out.LoginInfoDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/auth/v1")
@Controller
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
class AuthenticationControllerImpl implements AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    @Override
    public ResponseEntity<LoginInfoDTO> login(HttpServletRequest request, @RequestBody LoginDTO loginDTO) {
        log.info(loginDTO.toString());

        try {
            User login = authenticationService.login(loginDTO);
            request.getSession();
            return ResponseEntity.ok(LoginInfoDTO.builder()
                    .result(String.format("welcome %s", login.getName()))
                    .build()
            );
        } catch (RuntimeException e) {
            return ResponseEntity.ok(LoginInfoDTO.builder()
                    .result(e.getMessage())
                    .build()
            );
        }
    }

    @PostMapping("/logout")
    @Override
    public ResponseEntity<LogoutInfoDTO> logout(HttpServletRequest request) {
        if (request.isRequestedSessionIdValid()) {
            log.info("logout executed");
            HttpSession session = request.getSession();
            session.invalidate();
        }

        return ResponseEntity.ok(LogoutInfoDTO.builder()
                .result("bye")
                .build()
        );
    }
}