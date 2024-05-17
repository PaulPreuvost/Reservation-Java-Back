package com.gab1machine.fridge.storage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class StorageEntity {
    @Id
    private UUID id;
    @Column(nullable = false)
    private Integer size;
    @Column(nullable = false)
    private Date date;
}