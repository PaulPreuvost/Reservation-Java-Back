package com.gab1machine.fridge.storage;

import java.sql.Date;
import java.util.UUID;

public record StorageDto(UUID id, Date date, Integer size) {
}