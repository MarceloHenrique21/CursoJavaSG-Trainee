package com.semanaDois.semanaDois.Produto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/produto")
public class ProdutoAPI {

    @GetMapping("/teste")
    public ResponseEntity<String> teste(){
        return ResponseEntity.ok("teste");
    }
}
