package com.lanchonete.lanchonete.LogsEstoque;

import com.lanchonete.lanchonete.GerarId.GerarId;
import com.lanchonete.lanchonete.Produtos.Produto;
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
@Entity(name = "logsEstoque")
public class LogsEstoque extends GerarId {

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(name = "quantidade_alterada")
    private Integer quantidadeAlterada;

    @Column(name = "data_transacao")
    private LocalDateTime dataTransacao;
}
