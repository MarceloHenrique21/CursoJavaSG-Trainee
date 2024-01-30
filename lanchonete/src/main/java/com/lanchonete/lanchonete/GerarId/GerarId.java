package com.lanchonete.lanchonete.GerarId;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public class GerarId {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
}
