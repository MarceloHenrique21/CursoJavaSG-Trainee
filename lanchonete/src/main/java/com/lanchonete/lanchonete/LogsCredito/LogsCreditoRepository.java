package com.lanchonete.lanchonete.LogsCredito;

import com.lanchonete.lanchonete.Cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogsCreditoRepository extends JpaRepository<LogsCredito, Integer> {
    List<LogsCredito> findByCliente(Cliente cliente);
}
