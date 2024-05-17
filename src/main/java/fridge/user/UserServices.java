package fridge.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service

public class UserServices {

    private final UserRepository userRepository;

    public UserDto createUser(UserDto user) {
        UUID id = UUID.randomUUID();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName(user.name());
        UserEntity savedUser = this.userRepository.save(userEntity);
        return new UserDto(savedUser.getId(), savedUser.getName());
    }
}