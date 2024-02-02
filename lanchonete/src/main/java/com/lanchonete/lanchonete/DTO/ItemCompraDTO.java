package com.lanchonete.lanchonete.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemCompraDTO {
    private Integer id;
    private Integer quantidade;
    public ItemCompraDTO(Integer id, Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }
}
