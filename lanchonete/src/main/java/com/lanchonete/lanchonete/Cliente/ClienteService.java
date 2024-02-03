package com.lanchonete.lanchonete.Cliente;

import com.lanchonete.lanchonete.DTO.CompraDTO;
import com.lanchonete.lanchonete.DTO.ComprarProdutoDTO;
import com.lanchonete.lanchonete.DTO.ItemCompraDTO;
import com.lanchonete.lanchonete.LogsEstoque.LogsEstoque;
import com.lanchonete.lanchonete.LogsEstoque.LogsEstoqueRepository;
import com.lanchonete.lanchonete.Produtos.Produto;
import com.lanchonete.lanchonete.Produtos.ProdutoRepository;
import com.lanchonete.lanchonete.StatusProduto.StatusProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private ProdutoRepository produtoRepository;
    private LogsEstoqueRepository logsEstoqueRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, ProdutoRepository produtoRepository, LogsEstoqueRepository logsEstoqueRepository){
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.logsEstoqueRepository = logsEstoqueRepository;
    }

    @Transactional
    public Cliente salvaCliente(Cliente cliente){
       return this.clienteRepository.save(cliente);
    }

    public void CreditosValidar(Cliente cliente){
        if(cliente.getCreditos() > 0){
            throw new RuntimeException("o cliente nao pode ser cadastrado com credito");
        }
    }

    @Transactional
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

                LogsEstoque logsEstoque = new LogsEstoque();
                logsEstoque.setProduto(produto);
                logsEstoque.setQuantidadeAlterada(-quantidade);
                logsEstoque.setDataTransacao(LocalDateTime.now());

                logsEstoqueRepository.save(logsEstoque);

                System.out.println("Produto com ID " + idProduto + " comprado com sucesso. Novo estoque: " + produto.getEstoque());
            }

            System.out.println("Preço total da compra: " + precoTotal);
        }
    }

    public List<LogsEstoque> buscarHistoricoEstoqueProduto(Integer produtoId) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + produtoId));
        return logsEstoqueRepository.findByProduto(produto);
    }
}






