package com.gab1machine.fridge.reservation;

import com.gab1machine.fridge.storage.StorageDto;
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
    public @ResponseBody ResponseEntity<ReservationDto> getReservation(@RequestParam(name = "id", required = true) UUID id) {
        Optional<ReservationDto> dto = this.reservationServices.getReservation(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public @ResponseBody ResponseEntity<ReservationDto> postStorage(@RequestBody ReservationDto requestDto) {
        Optional<ReservationDto> dto = this.reservationServices.createReservation(requestDto);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
