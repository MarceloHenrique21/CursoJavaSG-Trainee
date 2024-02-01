package com.lanchonete.lanchonete.Lanchonete;

import com.lanchonete.lanchonete.GerarId.GerarId;
import com.lanchonete.lanchonete.Produtos.Produto;
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
@Entity(name = "lanchonete")
public class Lanchonete extends GerarId {

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "lanchonete")
    private List<Produto> produtos;
}
