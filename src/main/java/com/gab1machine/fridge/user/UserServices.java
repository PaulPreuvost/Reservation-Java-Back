package com.gab1machine.fridge.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Service

public class UserServices {

    private final UserRepository userRepository;

    private UserDto entityToDto(UserEntity entity) {
        return new UserDto(entity.getId(), entity.getName());
    }

    public UserDto createUser(UserDto user) {
        UUID id = UUID.randomUUID();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName(user.name());
        UserEntity savedUser = this.userRepository.save(userEntity);
        return new UserDto(savedUser.getId(), savedUser.getName());
    }

    public Optional<UserDto> getUser(UUID id) {
        Optional<UserEntity> entity = this.userRepository.findById(id);
        return entity.map(this::entityToDto);
    }
}