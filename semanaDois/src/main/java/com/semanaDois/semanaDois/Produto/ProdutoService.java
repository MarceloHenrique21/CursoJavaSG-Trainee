package com.semanaDois.semanaDois.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository){
     this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Produto Cadastrar(Produto produto){
        return this.produtoRepository.save(produto);
    }
}
