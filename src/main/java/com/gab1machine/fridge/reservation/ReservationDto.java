package com.gab1machine.fridge.reservation;

import com.gab1machine.fridge.common.NamedAPIResource;

import java.util.Date;
import java.util.UUID;

public record ReservationDto(UUID id, Date date, Integer size, NamedAPIResource storage) {
}
