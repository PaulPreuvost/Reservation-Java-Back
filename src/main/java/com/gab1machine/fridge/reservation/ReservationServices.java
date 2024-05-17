package com.gab1machine.fridge.reservation;

import com.gab1machine.fridge.common.NamedAPIResource;
import com.gab1machine.fridge.common.NamedAPIResourceServices;
import com.gab1machine.fridge.storage.StorageDto;
import com.gab1machine.fridge.storage.StorageEntity;
import com.gab1machine.fridge.storage.StorageServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ReservationServices {
    private final ReservationRepository reservationRepository;
    private final NamedAPIResourceServices namedAPIResourceServices;
    private final StorageServices storageServices;

    private ReservationDto entityToDto(ReservationEntity entity) {
        return new ReservationDto(entity.getId(), entity.getDate(), entity.getSize(),
                namedAPIResourceServices.storageResource(entity.getStorage())
        );
    }

    public Optional<ReservationDto> getReservation(UUID id) {
        Optional<ReservationEntity> entity = this.reservationRepository.findById(id);
        return entity.map(this::entityToDto);
    }

    private ReservationEntity createReservationEntity(ReservationDto reservationDto, StorageEntity storage) {
        ReservationEntity entity = new ReservationEntity();
        entity.setStorage(storage);
        entity.setDate(reservationDto.date());
        entity.setSize(reservationDto.size());
        return entity;
    }

    private ReservationEntity createAndPercistReservationEntity(ReservationDto reservationDto, StorageEntity storage) {
        ReservationEntity entity = this.createReservationEntity(reservationDto, storage);
        this.reservationRepository.save(entity);
        return entity;
    }

    public Optional<ReservationDto> createReservation(ReservationDto reservationDto) {
        Optional<StorageEntity> storageEntity = this.storageServices.getStorageEntity(reservationDto.storage().id());
        if (storageEntity.isEmpty()) {
            return Optional.empty();
        }
        ReservationEntity exampleEntity = new ReservationEntity();
        exampleEntity.setDate(reservationDto.date());
        exampleEntity.setStorage(storageEntity.get());
        List<ReservationEntity> reservations = this.reservationRepository.findAll(Example.of(exampleEntity));
        if (reservations.isEmpty()) {
            return Optional.of(this.entityToDto(this.createAndPercistReservationEntity(reservationDto, storageEntity.get())));
        }

        return Optional.of(this.entityToDto(this.createAndPercistReservationEntity(reservationDto, storageEntity.get())));
    }
}
