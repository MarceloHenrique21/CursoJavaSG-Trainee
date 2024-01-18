package com.Cinema.Cinema.Assentos;

import com.Cinema.Cinema.EntityID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Assentos")
public class Assentos extends EntityID {

    @Column(name = "fileira")
    private String fileira;

    @Column(name = "numero")
    private int numero;
}
