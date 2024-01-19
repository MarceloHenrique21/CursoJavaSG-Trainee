package com.Cinema.Cinema.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

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
}
