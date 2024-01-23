package com.Biblioteca.Biblioteca.Livro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AlugaEDevolveLivros {
    private Integer livroId;
    private List<Integer> numeros;
}
