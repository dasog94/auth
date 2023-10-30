package com.example.auth.user.controller.dto.in;

import lombok.*;

@ToString
@Getter
@Setter(AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginDTO {
    private String id;
    private String password;
}
