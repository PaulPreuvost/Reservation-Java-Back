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
        return new UserDto(entity.getId(), entity.getName(), entity.getEmail(), entity.getHashedPassword());
    }

    public Optional<UserDto> createUser(UserInputDto user) {
        if(this.userRepository.findByEmailAndHashedPassword(user.email(), user.hashedPassword()).isPresent()) {
            return Optional.empty();
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.name());
        userEntity.setEmail(user.email());
        userEntity.setHashedPassword(user.hashedPassword());
        UserEntity savedUser = this.userRepository.save(userEntity);
        return Optional.of(new UserDto(savedUser.getId(), savedUser.getName(), user.email(), user.hashedPassword()));
    }

    public Optional<UserDto> getUser(UUID id) {
        Optional<UserEntity> entity = this.userRepository.findById(id);
        return entity.map(this::entityToDto);
    }

    public boolean userExist(String email, String hashedPassword) {
        return this.userRepository.findByEmailAndHashedPassword(email, hashedPassword).isPresent();
    }
}