package com.GAB1NMACHINE.MicoWave.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class MicroWave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private User associedUserId;

    private float dateStart;

    private float dateEnd;

    // Constructeur par défaut
    public MicroWave() {
    }

    // Constructeur avec paramètre
    public MicroWave(User associedUserId) {
        this.associedUserId = associedUserId;
    }

}
