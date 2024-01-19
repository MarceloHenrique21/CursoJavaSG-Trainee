package com.Cinema.Cinema.Sessao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SessaoService {

    private final SessaoRepository sessaoRepository;

    @Autowired
    public SessaoService(SessaoRepository sessaoRepository){
        this.sessaoRepository = sessaoRepository;
    }

    @Transactional
    public Sessao cadastrarSessao(Sessao sessao){
        return this.sessaoRepository.save(sessao);
    }

}
