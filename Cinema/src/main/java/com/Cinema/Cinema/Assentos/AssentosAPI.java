package com.Cinema.Cinema.Assentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assentos")
public class AssentosAPI {

    private final AssentosService assentosService;

    @Autowired
    public AssentosAPI(AssentosService assentosService){
        this.assentosService = assentosService;
    }

    @PostMapping("")
    public ResponseEntity<Assentos> cadastrarAssentos(@RequestBody Assentos assentos){
        return ResponseEntity.ok(this.assentosService.cadastrarAssentos(assentos));
    }
}
