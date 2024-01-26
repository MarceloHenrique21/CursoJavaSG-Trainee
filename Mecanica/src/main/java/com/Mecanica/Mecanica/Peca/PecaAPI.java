package com.Mecanica.Mecanica.Peca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peca")
public class PecaAPI {

    private final PecaService pecaService;

    @Autowired
    public PecaAPI(PecaService pecaService){
        this.pecaService = pecaService;
    }

    @PostMapping
    public ResponseEntity cadastro(@RequestBody Peca peca){
        return ResponseEntity.ok(this.pecaService.cadastro(peca));
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody Peca peca,
                                    @PathVariable Integer id){
        return ResponseEntity.ok(this.pecaService.cadastro(peca));
    }
}
