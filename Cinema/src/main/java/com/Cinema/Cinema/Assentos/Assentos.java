package com.Cinema.Cinema.Assentos;

import com.Cinema.Cinema.EntityID;
import com.Cinema.Cinema.Sessao.Sessao;
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

    @Column(name = "disponivel")
    private boolean disponivel; // Adicionando a propriedade disponivel

    @ManyToOne
    @JoinColumn(name = "sessao_id")
    private Sessao sessao;
}
