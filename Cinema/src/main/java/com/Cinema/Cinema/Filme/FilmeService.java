package com.Cinema.Cinema.Filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    @Autowired public FilmeService(FilmeRepository filmeRepository1){
        this.filmeRepository = filmeRepository1;
    }

    @Transactional
    public Filme cadastrarFilme(Filme filme){
        return this.filmeRepository.save(filme);
    }

    @Transactional
    public void excluirFilme(Integer id){
        this.filmeRepository.deleteById(id);
    }

    @Transactional
    public List<Filme> buscarNome(String nome){
        return this.filmeRepository.findAllByNome("%" + nome + "%");
    }
}
