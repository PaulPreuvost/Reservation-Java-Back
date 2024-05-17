package com.gab1machine.fridge.reservation;

import com.gab1machine.fridge.storage.StorageDto;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

public record ReservationDto(UUID id, Date date, Integer size, StorageDto storage) {
}
