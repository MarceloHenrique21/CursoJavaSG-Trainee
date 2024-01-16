package com.Cinema.Cinema.Assentos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Assentos")
public class Assentos {

    @Column(name = "fileira")
    private int fileira;

    @Column(name = "numero")
    private int numero;
}
