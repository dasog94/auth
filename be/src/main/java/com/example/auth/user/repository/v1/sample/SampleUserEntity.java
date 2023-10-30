package com.example.auth.user.repository.v1.sample;

import com.example.auth.user.repository.entity.UserEntity;
import lombok.AccessLevel;
import lombok.Builder;

public class SampleUserEntity extends UserEntity {

    private static final SampleUserEntity sample = SampleUserEntity.builder()
            .id(1L)
            .userId("sample")
            .name("샘플")
            .build();

    @Builder(access = AccessLevel.PRIVATE)
    public SampleUserEntity(Long id, String userId, String name) {
        super(id, userId, name);
    }

    public static UserEntity createSample() {
        return sample;
    }
}
