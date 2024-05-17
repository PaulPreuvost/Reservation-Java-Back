package com.gab1machine.fridge.reservation;

import com.gab1machine.fridge.NamedAPIResource;
import com.gab1machine.fridge.storage.StorageDto;
import com.gab1machine.fridge.storage.StorageEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ReservationServices {
    private final ReservationRepository reservationRepository;

    private ReservationDto entityToDto(ReservationEntity entity) {
        UUID storageId = entity.getStorage().getId();
        return new ReservationDto(entity.getId(), entity.getDate(), entity.getSize(),
                new NamedAPIResource("storage", storageId ,"/storage?id=" + storageId.toString())
        );
    }

    public Optional<ReservationDto> getReservation(UUID id) {
        Optional<ReservationEntity> entity = this.reservationRepository.findById(id);
        return entity.map(this::entityToDto);
    }
}
