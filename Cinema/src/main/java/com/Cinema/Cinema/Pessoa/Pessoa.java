package com.Cinema.Cinema.Pessoa;

import com.Cinema.Cinema.Assentos.Assentos;
import com.Cinema.Cinema.EntityID;
import com.Cinema.Cinema.Sessao.Sessao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Pessoa")
public class Pessoa extends EntityID {

    @Column(name = "nome")
    private String nome;

    @JoinColumn(name = "Pessoa_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<Assentos> AssentosList;
}
