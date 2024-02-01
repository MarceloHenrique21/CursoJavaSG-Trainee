package com.lanchonete.lanchonete.DTO;

import com.lanchonete.lanchonete.Produtos.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class ProduzirProdutoDTO {
    List<Produto> produtoList;
}
