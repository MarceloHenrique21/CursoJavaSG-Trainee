package com.lanchonete.lanchonete.Cliente;

import com.lanchonete.lanchonete.DTO.ComprarProdutoDTO;
import com.lanchonete.lanchonete.DTO.ItemCompraDTO;
import com.lanchonete.lanchonete.Produtos.Produto;
import com.lanchonete.lanchonete.Produtos.ProdutoRepository;
import com.lanchonete.lanchonete.StatusProduto.StatusProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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

    public void comprarProdutos(List<ComprarProdutoDTO> dtos) {
        for (ComprarProdutoDTO dto : dtos) {
            double precoTotal = 0.0;

            for (ItemCompraDTO item : dto.getProdutos()) {
                Integer idProduto = item.getId();
                Integer quantidade = item.getQuantidade();

                Produto produto = produtoRepository.findById(idProduto)
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + idProduto));

                if (produto.getEstoque() < quantidade) {
                    throw new RuntimeException("Estoque insuficiente para realizar a compra do produto com ID: " + idProduto);
                }

                produto.setEstoque(produto.getEstoque() - quantidade);
                precoTotal += produto.getPreco() * quantidade;

                produtoRepository.save(produto);
                System.out.println("Produto com ID " + idProduto + " comprado com sucesso. Novo estoque: " + produto.getEstoque());
            }

            System.out.println("Preço total da compra: " + precoTotal);
        }
    }

}






