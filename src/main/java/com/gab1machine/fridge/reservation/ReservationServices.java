package com.gab1machine.fridge.reservation;

import com.gab1machine.fridge.common.NamedAPIResource;
import com.gab1machine.fridge.common.NamedAPIResourceServices;
import com.gab1machine.fridge.storage.StorageEntity;
import com.gab1machine.fridge.storage.StorageServices;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ReservationServices {
    private final ReservationRepository reservationRepository;
    private final StorageServices storageServices;
    private final NamedAPIResourceServices namedAPIResourceServices;

    private ReservationDto entityToDto(ReservationEntity entity) {
        return new ReservationDto(entity.getId(), entity.getDate(), entity.getSize(),
                namedAPIResourceServices.storageResource(this.storageServices.entityToDto(entity.getStorage()))
        );
    }

    public Optional<ReservationDto> getReservation(UUID id) {
        Optional<ReservationEntity> entity = this.reservationRepository.findById(id);
        return entity.map(this::entityToDto);
    }
}
