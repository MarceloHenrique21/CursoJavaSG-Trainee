package com.lanchonete.lanchonete.Produtos;

import com.lanchonete.lanchonete.GerarId.GerarId;
import com.lanchonete.lanchonete.MateriaPrima.MateriaPrima;
import com.lanchonete.lanchonete.StatusProduto.StatusProduto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "produtos")
public class Produtos extends GerarId {

    @Column(name = "nome")
    private String nome;

    @Column(name = "statusProduto")
    private StatusProduto Status;

    @OneToMany
    List<MateriaPrima> MateriaPrimaList;
}
