package com.Cinema.Cinema.Sessao;

import com.Cinema.Cinema.Assentos.Assentos;
import com.Cinema.Cinema.EntityID;
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
@Entity(name = "Sessao")
public class Sessao extends EntityID {

    @Column(name = "numeroDaSessao")
    private Integer numeroDaSessao;

    @Column(name = "horarioInicio")
    private Date horarioInicio;

    @Column(name = "horarioTermino")
    private Date horarioTermino;

    @JoinColumn(name = "Sessao_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<Assentos> assentoList;

}
