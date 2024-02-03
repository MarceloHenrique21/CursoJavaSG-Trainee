package com.lanchonete.lanchonete.MateriaPrima;

import com.lanchonete.lanchonete.GerarId.GerarId;
import com.lanchonete.lanchonete.Receita.Receita;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "materiaPrima")
public class MateriaPrima extends GerarId {

    @Column(name = "nome")
    private String nome;

    @Column(name = "estoque")
    private Integer estoque;

    @ManyToOne
    private Receita receita;
}
