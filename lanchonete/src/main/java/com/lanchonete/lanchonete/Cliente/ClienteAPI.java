package com.lanchonete.lanchonete.Cliente;

import com.lanchonete.lanchonete.DTO.ComprarProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/comprarProduto")
    public ResponseEntity<String> comprarProduto(@RequestBody ComprarProdutoDTO dto) {
        try {
            clienteService.ComprarProduto(dto);
            return ResponseEntity.ok("Compra realizada com sucesso!");

        } catch (RuntimeException e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
