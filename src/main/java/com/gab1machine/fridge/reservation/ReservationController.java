package com.gab1machine.fridge.reservation;

import com.gab1machine.fridge.storage.StorageDto;
import com.gab1machine.fridge.storage.StorageServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/reservation")
@RestController
public class ReservationController {
    private final ReservationServices reservationServices;

    @GetMapping
    public @ResponseBody ResponseEntity<ReservationDto> getStorage(@RequestParam(name = "id", required = true) UUID id) {
        Optional<ReservationDto> dto = this.reservationServices.getReservation(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
