package com.lanchonete.lanchonete.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompraDTO {
    private Integer valorTotal;
    private Integer custoTotal;
    private Integer lucroTotal;
}