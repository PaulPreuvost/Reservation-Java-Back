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
        return new ReservationDto(entity.getId(), entity.getDate(), entity.getSize(), entity.getStorage());
    }

    public ReservationOutputDto dtoToODto(ReservationDto dto) {
        return new ReservationOutputDto(dto.id(), dto.date(), dto.size(), namedAPIResourceServices.storageResource(dto.id()));
    }

    public Optional<ReservationDto> getReservation(UUID id) {
        Optional<ReservationEntity> entity = this.reservationRepository.findById(id);
        return entity.map(this::entityToDto);
    }

    private ReservationEntity createReservationEntity(ReservationDto reservationDto) {
        ReservationEntity entity = new ReservationEntity();
        entity.setStorage(reservationDto.storage());
        entity.setDate(reservationDto.date());
        entity.setSize(reservationDto.size());
        return entity;
    }

    private ReservationEntity createAndPercistReservationEntity(ReservationDto reservationDto) {
        ReservationEntity entity = this.createReservationEntity(reservationDto);
        this.reservationRepository.save(entity);
        return entity;
    }

    public Optional<ReservationDto> createReservation(ReservationDto reservationDto) {
        UUID storageId = reservationDto.storage();
        if (this.storageServices.exist(storageId)) {
            return Optional.empty();
        }
        ReservationEntity exampleEntity = new ReservationEntity();
        exampleEntity.setDate(reservationDto.date());
        exampleEntity.setStorage(storageId);
        List<ReservationEntity> reservations = this.reservationRepository.findAll(Example.of(exampleEntity));
        if (reservations.isEmpty()) {
            return Optional.of(this.entityToDto(this.createAndPercistReservationEntity(reservationDto)));
        }
        return Optional.of(this.entityToDto(this.createAndPercistReservationEntity(reservationDto)));
    }
}
