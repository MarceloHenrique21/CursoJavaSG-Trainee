package com.lanchonete.lanchonete.Produtos;

import com.lanchonete.lanchonete.StatusProduto.StatusProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Produto cadastrarProduto(Produto produto){
        if (validar(produto)) {
            return this.produtoRepository.save(produto);
        } else {
            throw new IllegalArgumentException("Produto não pode ser cadastrado: não atende aos critérios de validação.");
        }
    }

    public boolean validar(Produto produto){
        if ( produto.getEstoque() == 0){
            return true;
        }
        return false;
    }

    public void atualizarEstoque(Integer idProduto, int quantidade) {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        int estoqueAtual = produto.getEstoque();
        int novoEstoque = estoqueAtual + quantidade;

        if (novoEstoque < 0) {
            throw new IllegalArgumentException("Quantidade de estoque não pode ser negativa");
        }

        produto.setEstoque(novoEstoque);
        produtoRepository.save(produto);
    }
}
