package com.Mecanica.Mecanica.Peca;

import com.Mecanica.Mecanica.IdGerador.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "peca")
public class Peca extends EntityId {

    @Column(name = "nome")
    private String nome;

    @Column(name = "fabricante")
    private String fabricante;

    @Column(name = "qtdeEstoque")
    private Integer qtdeEstoque;

    @Column(name = "precoUnitario")
    private Integer precoUnitario;

    @Column(name = "dataCadastro")
    private Date dataCadastro;
}
