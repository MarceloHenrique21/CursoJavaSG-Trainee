package com.Hospital.Hospital.GerarID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class EntityId {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
}
