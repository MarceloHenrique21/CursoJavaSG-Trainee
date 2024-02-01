package com.lanchonete.lanchonete.MateriaPrima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/materias-primas")
public class MateriaPrimaAPI {

    private final MateriaPrimaService materiaPrimaService;

    @Autowired
    public MateriaPrimaAPI(MateriaPrimaService materiaPrimaService) {
        this.materiaPrimaService = materiaPrimaService;
    }

    @PostMapping
    public ResponseEntity<MateriaPrima> cadastrarMateriaPrima(@RequestBody MateriaPrima materiaPrima) {
        MateriaPrima novaMateriaPrima = materiaPrimaService.cadastrarMateriaPrima(materiaPrima);
        return new ResponseEntity<>(novaMateriaPrima, HttpStatus.CREATED);
    }
}
