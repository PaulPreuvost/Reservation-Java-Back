package com.gab1machine.fridge.authentication;

import com.gab1machine.fridge.user.UserDto;

import java.util.UUID;

public record UserAuthenticationDto(UUID id, String email, String hashedPassword) {
}
