package com.lanchonete.lanchonete.LogsCredito;

import com.lanchonete.lanchonete.Cliente.Cliente;
import com.lanchonete.lanchonete.GerarId.GerarId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "logsCredito")
public class LogsCredito extends GerarId {

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "credito_anterior")
    private Integer creditoAnterior;

    @Column(name = "credito_atual")
    private Integer creditoAtual;

    @Column(name = "data_transacao")
    private LocalDateTime dataTransacao;

}
