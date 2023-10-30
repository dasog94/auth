package com.example.auth.user.repository.entity;

import com.example.auth.user.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    private Long id;
    private String userId;
    private String name;

    public User createUser() {
        return User.builder()
                .userId(userId)
                .name(name)
                .build();
    }
}
