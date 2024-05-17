package fridge.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class UserEntity {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String name;
}