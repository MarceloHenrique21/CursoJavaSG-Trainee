package com.lanchonete.lanchonete.Lanchonete;

import com.lanchonete.lanchonete.Cliente.Cliente;
import com.lanchonete.lanchonete.DTO.ProduzirProdutoDTO;
import com.lanchonete.lanchonete.LogsCredito.LogsCredito;
import com.lanchonete.lanchonete.Produtos.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lanchonete")
public class LanchoneteAPI {

    private final LanchoneteService lanchoneteService;
    @Autowired
    public LanchoneteAPI(LanchoneteService lanchoneteService){
        this.lanchoneteService = lanchoneteService;
    }
    @PostMapping
    public ResponseEntity cadatrarLanchonete(@RequestBody Lanchonete lanchonete){
        return ResponseEntity.ok(this.lanchoneteService.cadastrarLanchonete(lanchonete));
    }

    @PostMapping("/produzirProduto")
    public ResponseEntity<String> produzirProduto(@RequestBody ProduzirProdutoDTO produzirProdutoDTO) {
        lanchoneteService.produzirProdutoUsandoReceita(produzirProdutoDTO);
        return ResponseEntity.ok("Produto produzido com sucesso!");
    }

    @PutMapping("/{clienteId}/adicionarCreditos")
    public ResponseEntity<?> adicionarCreditosAoCliente(@PathVariable Integer clienteId, @RequestParam Integer creditosAdicionais) {
        Cliente clienteAtualizado = lanchoneteService.adicionarCreditosAoCliente(clienteId, creditosAdicionais);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> getProdutos(@RequestParam(required = false) boolean comEstoque) {
        List<Produto> produtos;
        if (comEstoque) {
            produtos = lanchoneteService.buscarProdutosComEstoque();
        } else {
            produtos = lanchoneteService.buscarTodosProdutos();
        }
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/Trazerprodutos")
    public ResponseEntity<List<Produto>> getProdutos() {
        List<Produto> produtos = lanchoneteService.buscarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{clienteId}/historico-creditos")
    public ResponseEntity<List<LogsCredito>> getHistoricoCreditosCliente(@PathVariable Integer clienteId) {
        List<LogsCredito> historico = lanchoneteService.buscarHistoricoCreditosCliente(clienteId);
        return ResponseEntity.ok(historico);
    }

}
