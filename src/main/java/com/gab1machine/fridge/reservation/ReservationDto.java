package com.gab1machine.fridge.reservation;

import com.gab1machine.fridge.NamedAPIResource;
import com.gab1machine.fridge.storage.StorageDto;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public record ReservationDto(UUID id, Date date, Integer size, NamedAPIResource storage) {
}
