package com.lanchonete.lanchonete.DTO;

import com.lanchonete.lanchonete.StatusProduto.StatusProduto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ComprarProdutoDTO {
    private Date dataVenda;
    private List<ItemCompraDTO> produtos;
    public ComprarProdutoDTO(Date dataVenda, List<ItemCompraDTO> produtos) {
        this.dataVenda = dataVenda;
        this.produtos = produtos;
    }
}



