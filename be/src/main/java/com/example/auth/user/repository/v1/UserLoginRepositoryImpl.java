package com.example.auth.user.repository.v1;

import com.example.auth.user.model.UserLogin;
import com.example.auth.user.repository.UserLoginRepository;
import com.example.auth.user.repository.entity.UserLoginEntity;
import com.example.auth.user.repository.v1.sample.SampleUserLoginEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
class UserLoginRepositoryImpl implements UserLoginRepository {
    @Override
    public Optional<UserLogin> findUserLoginByUserId(String userId) {
        UserLoginEntity sample = SampleUserLoginEntity.createSample();
        if (!StringUtils.equals(sample.getUserId(), userId)) {
            return Optional.empty();
        }
        return Optional.of(sample.createUserLogin());
    }
}
