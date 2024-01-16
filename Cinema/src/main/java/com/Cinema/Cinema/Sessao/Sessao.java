package com.Cinema.Cinema.Sessao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @Column(name = "numeroDaSessao")
    private Integer numeroDaSessao;

    @Column(name = "horaInicio")
    private Date horaInicio;

    @Column(name = "horaFim")
    private Date horaFim;
}
