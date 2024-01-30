package com.lanchonete.lanchonete.Receita;

import com.lanchonete.lanchonete.GerarId.GerarId;
import com.lanchonete.lanchonete.MateriaPrima.MateriaPrima;
import com.lanchonete.lanchonete.Produtos.Produtos;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "receita")
public class Receita extends GerarId {

    @Column(name = "nomeReceita")
    private String nomeReceita; // ex: receita de pao

    List<Produtos> ProdutosList;
}
