package com.Cinema.Cinema.Filme;

import com.Cinema.Cinema.DTO.GerarSessoesAssentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Objects;

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

   @Transactional(readOnly = true)
   public Filme getById(Integer id) {
        return this.filmeRepository.findById(id).orElse(null);
    }

    @Transactional
    public void gerarSessoesAssentos(GerarSessoesAssentos dto){
        Filme filme = this.getById(dto.getFilmeID());
        filme.setSessaoList(filme.SessaoList);

        if(Objects.nonNull(filme)){

            this.cadastrarFilme(filme);
        }else{
            throw new RuntimeException("filme nao encontrado");
        }
    }
}
