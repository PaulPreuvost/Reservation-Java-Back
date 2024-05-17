package com.gab1machine.fridge.reservation;

import com.gab1machine.fridge.storage.StorageEntity;

import com.gab1machine.fridge.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID storage;
    @Column(nullable = false)
    private int size;
    @Column(nullable = false)
    private Date date;
}
