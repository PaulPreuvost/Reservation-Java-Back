package com.gab1machine.fridge.authentication;

import com.gab1machine.fridge.common.NamedAPIResource;
import com.gab1machine.fridge.user.UserEntity;

import java.util.Date;

public record TokenOutputDto(String id, NamedAPIResource<UserEntity> owner, Date createdAt, Date endAt) {
}
