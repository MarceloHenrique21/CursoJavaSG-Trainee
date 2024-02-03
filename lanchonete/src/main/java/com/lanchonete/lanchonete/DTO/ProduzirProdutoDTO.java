package com.lanchonete.lanchonete.DTO;

import com.lanchonete.lanchonete.MateriaPrima.MateriaPrima;
import com.lanchonete.lanchonete.Produtos.Produto;
import com.lanchonete.lanchonete.Receita.Receita;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class ProduzirProdutoDTO {
    private String nomeProduto;
    private Integer idReceita;
    private Integer preco;
}
