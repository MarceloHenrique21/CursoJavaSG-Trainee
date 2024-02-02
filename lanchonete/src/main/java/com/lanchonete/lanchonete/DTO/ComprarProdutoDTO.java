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
    private List<Integer> idProduto;

    public ComprarProdutoDTO(List<Integer> idProduto) {
        this.dataVenda = new Date();
        this.idProduto = idProduto;
    }
}


