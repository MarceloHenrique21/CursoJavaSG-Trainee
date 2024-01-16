
package com.semanaDois.semanaDois.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    private final com.semanaDois.semanaDois.Produto.ProdutoRepository produtoRepository;

    // Injeção de dependência do ProdutoRepository no construtor da ProdutoService
    @Autowired
    public ProdutoService(com.semanaDois.semanaDois.Produto.ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Método transacional para cadastrar um novo produto
    @Transactional
    public com.semanaDois.semanaDois.Produto.Produto cadastrar(com.semanaDois.semanaDois.Produto.Produto produto) {
        return this.produtoRepository.save(produto);
    }

    // Método para obter um produto pelo ID
    public com.semanaDois.semanaDois.Produto.Produto pegarPorId(Integer id) {
        return this.produtoRepository.findById(id).orElse(null);
    }

    // Método transacional para deletar um produto pelo ID
    @Transactional
    public void deletarProduto(Integer id) {
        this.produtoRepository.deleteById(id);
    }

    // Método transacional somente leitura para buscar produtos por nome
    @Transactional(readOnly = true)
    public List<com.semanaDois.semanaDois.Produto.Produto> findByNome(String nome) {
        return this.produtoRepository.findAllByNome("%" + nome + "%");
    }
}
