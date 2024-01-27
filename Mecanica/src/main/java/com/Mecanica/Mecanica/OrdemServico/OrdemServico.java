package com.Mecanica.Mecanica.OrdemServico;

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
@Entity(name = "OrdemServico")
public class OrdemServico extends EntityId {

    @Column(name = "servico_id")
    private Integer servico_id;

    @Column(name = "peca_id")
    private Integer peca_id;

    @Column(name = "qtdePeca")
    private Integer qtdePeca;

    @Column(name = "veiculo_id")
    private Integer veiculo_id;

    @Column(name = "cliente_id")
    private Integer cliente_id;

    @Column(name = "dataInicio")
    private Date dataInicio;

    @Column(name = "dataFinalizacao")
    private Date dataFinalziacao;
}
