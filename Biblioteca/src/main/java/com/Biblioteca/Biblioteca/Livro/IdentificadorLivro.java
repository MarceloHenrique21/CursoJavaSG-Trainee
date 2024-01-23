package com.Biblioteca.Biblioteca.Livro;

import com.Biblioteca.Biblioteca.EntityID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "identificador_de_livro")
public class IdentificadorLivro extends EntityID {
    @Column(name = "pessoa_id")
    private Integer pessoaId;
    @Column(name = "numero")
    private Integer numero;

    public IdentificadorLivro(Integer numero) {
        this.numero = numero;
    }
}