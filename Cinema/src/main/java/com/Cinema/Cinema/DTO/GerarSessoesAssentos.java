package com.Cinema.Cinema.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GerarSessoesAssentos {
    Integer filmeID;
    Integer numeroSessoes;
    Integer numeroAssentos;
}
