package com.lanchonete.lanchonete.MateriaPrima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materiaPrima")
public class MateriaPrimaAPI {

    private final MateriaPrimaService materiaPrimaService;

    @Autowired
    public MateriaPrimaAPI(MateriaPrimaService materiaPrimaService) {
        this.materiaPrimaService = materiaPrimaService;
    }

    @PostMapping
    public ResponseEntity<MateriaPrima> cadastrarMateriaPrima(@RequestBody MateriaPrima materiaPrima) {
        return ResponseEntity.ok(this.materiaPrimaService.cadastrarMateriaPrima(materiaPrima));
    }

    @PutMapping("/estoque/{id}")
    public ResponseEntity<String> atualizarEstoque(@PathVariable Integer id, @RequestParam int quantidade) {
        try {
            materiaPrimaService.atualizarEstoque(id, quantidade);
            return ResponseEntity.ok("Estoque atualizado com sucesso");

        } catch (IllegalArgumentException e) {

            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (RuntimeException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
    }
}
