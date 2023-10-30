package com.example.auth.user.service;

import com.example.auth.user.controller.dto.in.LoginDTO;
import com.example.auth.user.model.User;

public interface AuthenticationService {
    User login(LoginDTO loginDTO);
}
