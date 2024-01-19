package com.Cinema.Cinema.Pessoa;

import com.Cinema.Cinema.Assentos.Assentos;
import com.Cinema.Cinema.DTO.ComprarAssentoDTO;
import com.Cinema.Cinema.Filme.Filme;
import com.Cinema.Cinema.Filme.FilmeService;
import com.Cinema.Cinema.Sessao.Sessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private FilmeService filmeService;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public Pessoa cadastrarPessoa (Pessoa pessoa){
        return this.pessoaRepository.save(pessoa);
    }

    @Transactional
    public List<Pessoa> buscarNome(String nome){
        return this.pessoaRepository.findAllByNome("%" + nome + "%");
    }

    public ResponseEntity<String> comprarAssento(Integer filmeId, Integer pessoaId, ComprarAssentoDTO comprarAssentoDTO) {
        Filme filme = filmeService.getById(filmeId);
        Pessoa pessoa = pessoaRepository.getById(pessoaId);

        if (filme == null || pessoa == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme ou Pessoa não encontrados.");
        }

        Sessao sessao = filme.getSessaoList().stream()
                .filter(s -> s.getId().equals(comprarAssentoDTO.getSessaoID()))
                .findFirst()
                .orElse(null);

        if (sessao == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sessão não encontrada.");
        }

        List<Assentos> assentos = sessao.getAssentoList().stream()
                .filter(a -> comprarAssentoDTO.getNumerosAssentos().contains(a.getNumero()))
                .collect(Collectors.toList());

        if (assentos.size() != comprarAssentoDTO.getNumerosAssentos().size()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Alguns assentos selecionados não estão disponíveis.");
        }

        pessoa.getAssentosList().addAll(assentos);
        pessoaRepository.save(pessoa);

        return ResponseEntity.ok("Ingressos comprados com sucesso.");
    }

}
