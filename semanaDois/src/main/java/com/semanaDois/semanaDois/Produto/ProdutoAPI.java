
package com.semanaDois.semanaDois.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoAPI {

    private final com.semanaDois.semanaDois.Produto.ProdutoService produtoService;

    // Injeção de dependência do ProdutoService no construtor da ProdutoAPI
    @Autowired
    public ProdutoAPI(com.semanaDois.semanaDois.Produto.ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Endpoint para cadastrar um novo produto
    @PostMapping("")
    public ResponseEntity<com.semanaDois.semanaDois.Produto.Produto> cadastrar(@RequestBody com.semanaDois.semanaDois.Produto.Produto produto) {
        return ResponseEntity.ok(this.produtoService.cadastrar(produto));
    }

    // Endpoint para atualizar um produto existente com base no ID
    @PutMapping("/{id}")
    public ResponseEntity<com.semanaDois.semanaDois.Produto.Produto> atualizar(@RequestBody com.semanaDois.semanaDois.Produto.Produto produto) {
        return ResponseEntity.ok(this.produtoService.cadastrar(produto));
    }

    // Endpoint para obter um produto pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<com.semanaDois.semanaDois.Produto.Produto> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.produtoService.pegarPorId(id));
    }

    // Endpoint para deletar um produto pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.produtoService. deletarProduto(id);
        return ResponseEntity.accepted().build();
    }

    // Endpoint para buscar produtos por nome usando um parâmetro de consulta
    @GetMapping("/por-nome")
    public ResponseEntity<List<com.semanaDois.semanaDois.Produto.Produto>> findByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.produtoService.findByNome(nome));
    }
}
