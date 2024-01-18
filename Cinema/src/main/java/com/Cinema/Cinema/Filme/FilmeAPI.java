package com.Cinema.Cinema.Filme;

import com.Cinema.Cinema.DTO.GerarSessoesAssentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeAPI {

    private final FilmeService filmeService;

    @Autowired
    public FilmeAPI(FilmeService filmeService){
        this.filmeService = filmeService;
    }

    @PostMapping("")
    public ResponseEntity<Filme> cadastraFilme(@RequestBody Filme filme){
        return ResponseEntity.ok(this.filmeService.cadastrarFilme(filme));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(@RequestBody Filme filme) {
        return ResponseEntity.ok(this.filmeService.cadastrarFilme(filme));
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<Filme>> buscarNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.filmeService.buscarNome(nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id){
        this.filmeService.excluirFilme(id);
        return ResponseEntity.accepted().build();
    }


    @PostMapping("/gerar-sessoes-assentos")
    public ResponseEntity gerarSessoesAssentos(@RequestBody GerarSessoesAssentos gerarSessoesAssentos){
       this.gerarSessoesAssentos(gerarSessoesAssentos);
        return ResponseEntity.accepted().build();
    }
}
