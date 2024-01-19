package com.Cinema.Cinema.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ComprarAssentoDTO {
    private Integer sessaoID;
    private List<Integer> numerosAssentos;
}
