// ProdutoService.java

package com.semanadois.semanadois.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    // Injeção de dependência do ProdutoRepository no construtor da ProdutoService
    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Método transacional para cadastrar um novo produto
    @Transactional
    public Produto cadastrar(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    // Método para obter um produto pelo ID
    public Produto pegarPorId(Integer id) {
        return this.produtoRepository.findById(id).orElse(null);
    }

    // Método transacional para deletar um produto pelo ID
    @Transactional
    public void deletarProduto(Integer id) {
        this.produtoRepository.deleteById(id);
    }

    // Método transacional somente leitura para buscar produtos por nome
    @Transactional(readOnly = true)
    public List<Produto> findByNome(String nome) {
        return this.produtoRepository.findAllByNome("%" + nome + "%");
    }
}
