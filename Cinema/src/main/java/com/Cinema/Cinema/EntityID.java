package com.Cinema.Cinema;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class EntityID {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
}
