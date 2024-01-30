package com.lanchonete.lanchonete.Lanchonete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lanchonete")
public class LanchoneteAPI {

    private final LanchoneteService lanchoneteService;

    @Autowired
    public LanchoneteAPI(LanchoneteService lanchoneteService){
        this.lanchoneteService = lanchoneteService;
    }

    @PostMapping
    public ResponseEntity cadatrarLanchonete(@RequestBody Lanchonete lanchonete){
        return ResponseEntity.ok(this.lanchoneteService.cadastrarLanchonete(lanchonete));
    }
}
