package com.lanchonete.lanchonete.MateriaPrima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/materiaPrima")
public class MateriaPrimaAPI {

    private final MateriaPrimaService materiaPrimaService;

    @Autowired
    public MateriaPrimaAPI(MateriaPrimaService materiaPrimaService){
        this.materiaPrimaService = materiaPrimaService;
    }

    @PostMapping
    public ResponseEntity cadastrarMateriaPrima(@RequestBody MateriaPrima materiaPrima){
        return ResponseEntity.ok(this.materiaPrimaService.cadastrarMateriaPrima(materiaPrima));
    }
}
