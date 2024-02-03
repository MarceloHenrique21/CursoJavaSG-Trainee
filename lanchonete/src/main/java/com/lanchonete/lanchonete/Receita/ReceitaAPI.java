package com.lanchonete.lanchonete.Receita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receita")
public class ReceitaAPI {

    private final ReceitaService receitaService;

    @Autowired
    public ReceitaAPI(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

    @PostMapping
    public ResponseEntity<Receita> cadastrarReceita(@RequestBody Receita receita) {
        return ResponseEntity.ok(this.receitaService.cadastrarReceita(receita));
    }
}
