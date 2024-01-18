package com.Cinema.Cinema.Filme;

import com.Cinema.Cinema.Assentos.Assentos;
import com.Cinema.Cinema.EntityID;
import com.Cinema.Cinema.Sessao.Sessao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Filme")
public class Filme extends EntityID {

    @Column(name = "nome")
    private String nome;

    @Column(name = "InicioCartaz")
    private Date InicioCartaz;

    @Column(name = "FimCartaz")
    private Date FimCartaz;

    @JoinColumn(name = "Filme_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<Sessao> SessaoList;
}
