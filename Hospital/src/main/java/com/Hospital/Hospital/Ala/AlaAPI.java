package com.Hospital.Hospital.Ala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ala")
public class AlaAPI {
    private final AlaService alaService;

    @Autowired
    public AlaAPI(AlaService alaService){
        this.alaService = alaService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Ala ala){
        return ResponseEntity.ok(this.alaService.salvar(ala));
    }
}
