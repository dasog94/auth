package com.example.auth.user.repository.v1;

import com.example.auth.user.model.User;
import com.example.auth.user.repository.UserRepository;
import com.example.auth.user.repository.entity.UserEntity;
import com.example.auth.user.repository.v1.sample.SampleUserEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<User> findUserByUserId(String userId) {
        UserEntity sample = SampleUserEntity.createSample();
        if (!StringUtils.equals(sample.getUserId(), userId)){
            return Optional.empty();
        }

        return Optional.of(sample.createUser());
    }
}
