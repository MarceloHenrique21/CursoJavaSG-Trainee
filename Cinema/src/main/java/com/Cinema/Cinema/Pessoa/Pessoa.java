package com.Cinema.Cinema.Pessoa;

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
@Entity(name = "Pessoa")
public class Pessoa {

    @Column(name = "nome")
    private String nome;
}
