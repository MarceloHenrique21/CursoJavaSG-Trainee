package com.lanchonete.lanchonete.Produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoAPI {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoAPI(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity cadastrarProduto(@RequestBody Produto produto){
        return ResponseEntity.ok(this.produtoService.cadastrarProduto(produto));
    }

    @PatchMapping("/estoque/{id}")
    public ResponseEntity<String> atualizarEstoque(@PathVariable Integer id, @RequestParam int quantidade) {
        try {
            produtoService.atualizarEstoque(id, quantidade);
            return ResponseEntity.ok("Estoque atualizado com sucesso");

        } catch (IllegalArgumentException e) {

            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (RuntimeException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
    }
}
