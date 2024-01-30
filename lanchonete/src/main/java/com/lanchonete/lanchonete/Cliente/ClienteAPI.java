package com.lanchonete.lanchonete.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
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
}
