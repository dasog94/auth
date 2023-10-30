package com.example.auth.user.repository.entity;

import com.example.auth.user.model.UserLogin;
import lombok.*;

@Getter
@Setter(AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLoginEntity {
    private Long id;
    private String userId;
    private String password;

    public UserLogin createUserLogin() {
        return UserLogin.builder()
                .userId(userId)
                .password(password)
                .build();
    }
}
