package com.example.auth.user.repository.v1.sample;

import com.example.auth.user.repository.entity.UserLoginEntity;
import lombok.AccessLevel;
import lombok.Builder;

public class SampleUserLoginEntity extends UserLoginEntity {

    private static final SampleUserLoginEntity SAMPLE = SampleUserLoginEntity.builder()
            .id(1L)
            .userId(SampleUserEntity.createSample()
                    .getUserId())
            .password("sample")
            .build();

    @Builder(access = AccessLevel.PACKAGE)
    public SampleUserLoginEntity(Long id, String userId, String password) {
        super(id, userId, password);
    }

    public static UserLoginEntity createSample() {
        return SAMPLE;
    }
}
