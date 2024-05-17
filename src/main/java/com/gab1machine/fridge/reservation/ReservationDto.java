package com.gab1machine.fridge.reservation;

import java.sql.Date;
import java.util.UUID;

public record ReservationDto(UUID id, Date date, Integer size) {
}
