package com.lanchonete.lanchonete.Cliente;

import com.lanchonete.lanchonete.DTO.CompraDTO;
import com.lanchonete.lanchonete.DTO.ComprarProdutoDTO;
import com.lanchonete.lanchonete.LogsEstoque.LogsEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteAPI {

    private final ClienteService clienteService;

    @Autowired
    public ClienteAPI(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Cliente cliente){
        return ResponseEntity.ok(this.clienteService.salvaCliente(cliente));
    }

    @PostMapping("/comprar")
    public ResponseEntity<String> comprarProdutos(@RequestBody List<ComprarProdutoDTO> dtos) {
        try {
            clienteService.comprarProdutos(dtos);
            return ResponseEntity.ok("Compras realizadas com sucesso!");

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{produtoId}/historicoEstoque")
    public ResponseEntity<List<LogsEstoque>> buscarHistoricoEstoqueProduto(@PathVariable Integer produtoId) {
        List<LogsEstoque> historicoEstoque = clienteService.buscarHistoricoEstoqueProduto(produtoId);
        return ResponseEntity.ok(historicoEstoque);
    }
}
