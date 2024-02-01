package com.lanchonete.lanchonete.Cliente;

import com.lanchonete.lanchonete.DTO.ComprarProdutoDTO;
import com.lanchonete.lanchonete.Produtos.Produto;
import com.lanchonete.lanchonete.Produtos.ProdutoRepository;
import com.lanchonete.lanchonete.StatusProduto.StatusProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private ProdutoRepository produtoRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, ProdutoRepository produtoRepository){
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Cliente salvaCliente(Cliente cliente){
       return this.clienteRepository.save(cliente);
    }

    @Transactional
    public void ComprarProduto(ComprarProdutoDTO dto){

        Date dataVenda = dto.getDataVenda();
        Integer idProduto = dto.getIdProduto();
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Integer novoEstoque = produto.getEstoque() - 1;
        produto.setEstoque(novoEstoque);

        if (novoEstoque < 0) {
            throw new RuntimeException("Estoque insuficiente para realizar a compra.");
        }

        if (!produto.getStatus().equals("JAFABRICADO") && !produto.getStatus().equals("NAOFABRICAVEL")) {
            throw new RuntimeException("Este produto não está disponível para compra no momento.");
        }
    }
}
