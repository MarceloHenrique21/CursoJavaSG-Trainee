package com.lanchonete.lanchonete.Lanchonete;

import com.lanchonete.lanchonete.Cliente.Cliente;
import com.lanchonete.lanchonete.Cliente.ClienteRepository;
import com.lanchonete.lanchonete.DTO.ProduzirProdutoDTO;
import com.lanchonete.lanchonete.LogsCredito.LogsCredito;
import com.lanchonete.lanchonete.LogsCredito.LogsCreditoRepository;
import com.lanchonete.lanchonete.MateriaPrima.MateriaPrima;
import com.lanchonete.lanchonete.MateriaPrima.MateriaPrimaRepository;
import com.lanchonete.lanchonete.Produtos.Produto;
import com.lanchonete.lanchonete.Produtos.ProdutoRepository;
import com.lanchonete.lanchonete.Receita.Receita;
import com.lanchonete.lanchonete.Receita.ReceitaRepository;
import com.lanchonete.lanchonete.StatusProduto.StatusProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LanchoneteService {

    private LanchoneteRespository lanchoneteRespository;
    private ProdutoRepository produtoRepository;
    private MateriaPrimaRepository materiaPrimaRepository;
    private ReceitaRepository receitaRepository;
    private ClienteRepository clienteRepository;
    private LogsCreditoRepository logsCreditoRepository;

    private final Logger logger = LoggerFactory.getLogger(LanchoneteService.class);
    @Autowired
    public LanchoneteService(LanchoneteRespository lanchoneteRespository, ProdutoRepository produtoRepository, MateriaPrimaRepository materiaPrimaRepository,
                             ReceitaRepository receitaRepository, ClienteRepository clienteRepository, LogsCreditoRepository logsCreditoRepository){
        this.lanchoneteRespository = lanchoneteRespository;
        this.produtoRepository = produtoRepository;
        this.materiaPrimaRepository = materiaPrimaRepository;
        this.receitaRepository = receitaRepository;
        this.clienteRepository = clienteRepository;
        this.logsCreditoRepository = logsCreditoRepository;
    }

    @Transactional
    public Lanchonete cadastrarLanchonete(Lanchonete lanchonete){
       return this.lanchoneteRespository.save(lanchonete);
    }

    public Produto produzirProdutoUsandoReceita(ProduzirProdutoDTO produzirProdutoDTO) {
        String nomeProduto = produzirProdutoDTO.getNomeProduto();
        Integer idReceita = produzirProdutoDTO.getIdReceita();
        Integer preco = produzirProdutoDTO.getPreco();

        Receita receita = receitaRepository.findById(idReceita)
                .orElseThrow(() -> new IllegalArgumentException("Receita não encontrada com ID: " + idReceita));

        List<MateriaPrima> materiasPrimas = receita.getMateriaPrimaList();

        for (MateriaPrima materiaPrima : materiasPrimas) {
            if (materiaPrima.getEstoque() == null || materiaPrima.getEstoque() <= 0) {
                throw new RuntimeException("Estoque insuficiente para a matéria-prima: " + materiaPrima.getNome());
            }
        }

        Produto novoProduto = new Produto();
        novoProduto.setNome(nomeProduto);
        novoProduto.setPreco(preco);
        novoProduto.setQuantidade(1);
        novoProduto.setEstoque(1);

        Produto produtoSalvo = produtoRepository.save(novoProduto);

        for (MateriaPrima materiaPrima : materiasPrimas) {
            int quantidadeUtilizada = 1;
            int estoqueAtual = materiaPrima.getEstoque();
            materiaPrima.setEstoque(estoqueAtual - quantidadeUtilizada);
            materiaPrimaRepository.save(materiaPrima);
        }

        return produtoSalvo;
    }

    public Cliente adicionarCreditosAoCliente(Integer clienteId, Integer creditosAdicionais) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com ID: " + clienteId));

        Integer creditoAnterior = cliente.getCreditos();
        Integer novoCredito = creditoAnterior + creditosAdicionais;

        cliente.setCreditos(novoCredito);

        LogsCredito logsCredito = new LogsCredito();
        logsCredito.setCliente(cliente);
        logsCredito.setCreditoAnterior(creditoAnterior);
        logsCredito.setCreditoAtual(novoCredito);
        logsCredito.setDataTransacao(LocalDateTime.now());
        logsCreditoRepository.save(logsCredito);

        return clienteRepository.save(cliente);
    }

    public List<Produto> buscarProdutos() {
        return produtoRepository.findAll();
    }

    public List<Produto> buscarProdutosComEstoque() {
        return produtoRepository.findByEstoqueGreaterThan(0);
    }

    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public List<LogsCredito> buscarHistoricoCreditosCliente(Integer clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com ID: " + clienteId));
        return logsCreditoRepository.findByCliente(cliente);
    }

}
