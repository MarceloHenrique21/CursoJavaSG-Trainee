package com.Cinema.Cinema.Sessao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Sessao")
public class Sessao {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "numeroDaSessao")
    private Integer numeroDaSessao;

    @Column(name = "horaInicio")
    private Date horaInicio;

    @Column(name = "horaFim")
    private Date horaFim;
}
