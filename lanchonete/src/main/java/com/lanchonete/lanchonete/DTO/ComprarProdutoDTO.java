package com.lanchonete.lanchonete.DTO;

import com.lanchonete.lanchonete.StatusProduto.StatusProduto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ComprarProdutoDTO {
    private Date dataVenda;
    private Integer idProduto;
    private StatusProduto statusLanches = StatusProduto.JAFABRICADO;
    private StatusProduto statusOutros = StatusProduto.NAOFABRICAVEL;
}
