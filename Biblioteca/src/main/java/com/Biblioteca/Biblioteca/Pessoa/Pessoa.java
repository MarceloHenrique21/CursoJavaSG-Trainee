package com.Biblioteca.Biblioteca.Pessoa;

import com.Biblioteca.Biblioteca.EntityID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pessoa")
public class Pessoa extends EntityID {

    @Column(name = "nome")
    private String nome;
}
