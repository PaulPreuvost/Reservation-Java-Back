package com.gab1machine.fridge.user;

import java.util.UUID;

public record UserDto (UUID id, String name, String email, String hashedPassword) {}