package com.Mecanica.Mecanica.Cliente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteAPI {

    private final ClienteService clienteService;

    @Autowired
    public ClienteAPI(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity cadastro(@RequestBody Cliente cliente){
        return ResponseEntity.ok(this.clienteService.cadastro(cliente));
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar(@RequestBody Cliente cliente,
                                    @PathVariable Integer id){
        return ResponseEntity.ok(this.clienteService.cadastro(cliente));
    }
}
