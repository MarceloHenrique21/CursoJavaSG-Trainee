package com.lanchonete.lanchonete.Cliente;

import com.lanchonete.lanchonete.DTO.ComprarProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
