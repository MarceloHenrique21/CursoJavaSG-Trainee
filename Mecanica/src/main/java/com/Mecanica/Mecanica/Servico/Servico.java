package com.Mecanica.Mecanica.Servico;

import com.Mecanica.Mecanica.IdGerador.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "servico")
public class Servico extends EntityId {

    @Column(name = "nome")
    private String nome;

    @Column(name = "precoMaoObra")
    private Integer precoMaoObra;

    @Column(name = "dataCadastro")
    private Date dataCadastro;
}
