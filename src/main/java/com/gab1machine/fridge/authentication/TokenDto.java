package com.gab1machine.fridge.authentication;

import com.gab1machine.fridge.common.NamedAPIResource;
import com.gab1machine.fridge.user.UserEntity;

import java.util.Date;
import java.util.UUID;

public record TokenDto(String id, UUID ownerId, Date createdAt, Date endAt) {
}
