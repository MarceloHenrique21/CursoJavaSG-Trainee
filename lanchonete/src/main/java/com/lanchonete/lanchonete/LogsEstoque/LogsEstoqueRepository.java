package com.lanchonete.lanchonete.LogsEstoque;

import com.lanchonete.lanchonete.Produtos.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LogsEstoqueRepository extends JpaRepository<LogsEstoque, Integer> {
    List<LogsEstoque> findByProduto(Produto produto);

    List<LogsEstoque> findByDataTransacaoBetween(LocalDateTime localDateTime, LocalDateTime localDateTime1);
}
