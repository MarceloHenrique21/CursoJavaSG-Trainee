package com.Mecanica.Mecanica.Serviço;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servico")
public class ServicoAPI {

    private final ServicoService servicoService;

    @Autowired
    public ServicoAPI(ServicoService servicoService){
        this.servicoService = servicoService;
    }

    @PostMapping
    public ResponseEntity cadastro (@RequestBody Servico servico){
        return ResponseEntity.ok(this.servicoService.cadastro(servico));
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar (@RequestBody Servico servico,
                                     Integer servicoId){
        return ResponseEntity.ok(this.servicoService.cadastro(servico));
    }
}
