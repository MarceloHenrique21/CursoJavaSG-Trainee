package com.Cinema.Cinema.Filme;

import com.Cinema.Cinema.Assentos.Assentos;
import com.Cinema.Cinema.DTO.GerarSessoesAssentos;
import com.Cinema.Cinema.Sessao.Sessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    @Autowired public FilmeService(FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
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
    public ResponseEntity<String> gerarSessoesAssentos(GerarSessoesAssentos dto) {
        Filme filme = this.getById(dto.getFilmeID());

        if (Objects.nonNull(filme)) {
            filme.setSessaoList(new ArrayList<>());

            for (int i = 0; i < dto.getNumeroSessoes(); i++) {
                Sessao sessao = new Sessao();

                sessao.setNumeroDaSessao(i + 1);
                sessao.setHorarioInicio(new Date());
                sessao.setAssentoList(new ArrayList<>());

                for (int j = 0; j < dto.getNumeroAssentos(); j++) {
                    Assentos assento = new Assentos();
                    assento.setNumero(j + 1);
                    assento.setFileira("A");

                    sessao.getAssentoList().add(assento);
                }

                filme.getSessaoList().add(sessao);
            }

            this.cadastrarFilme(filme);

            return ResponseEntity.ok("Sessões e assentos gerados com sucesso");

        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado");
        }
    }
}
