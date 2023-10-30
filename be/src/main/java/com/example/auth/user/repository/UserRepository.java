package com.example.auth.user.repository;

import com.example.auth.user.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findUserByUserId(String userId);
}
