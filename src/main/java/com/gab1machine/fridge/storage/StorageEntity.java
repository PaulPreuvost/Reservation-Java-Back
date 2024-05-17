package com.gab1machine.fridge.storage;

import com.gab1machine.fridge.reservation.ReservationEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class StorageEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private Integer size;
    @Column(nullable = false)
    private Date date;
    @OneToMany(mappedBy = "storage")
    private Set<ReservationEntity> reservations;
}