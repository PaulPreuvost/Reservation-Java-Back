package com.GAB1NMACHINE.MicoWave.entity;

import jakarta.persistence.*;

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

    public MicroWave() {
    }

    public MicroWave(User associedUserId) {
        this.associedUserId = associedUserId;
    }

}
