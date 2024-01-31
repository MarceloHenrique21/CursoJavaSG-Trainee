package com.lanchonete.lanchonete.Produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
