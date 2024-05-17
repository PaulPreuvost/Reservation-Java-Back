package com.gab1machine.fridge.authentication;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
public class TokenEntity {
    @Id
    private String id;

    @Column(nullable = false)
    private UUID ownerId;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private Date endAt;

}
