package com.example.auth.user.repository;

import com.example.auth.user.model.UserLogin;

import java.util.Optional;

public interface UserLoginRepository {
    Optional<UserLogin> findUserLoginByUserId(String userId);
}
