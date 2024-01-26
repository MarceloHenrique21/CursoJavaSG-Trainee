package com.Mecanica.Mecanica.Servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicoService {

    private ServicoRepository servicoRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository){
        this.servicoRepository = servicoRepository;
    }

    public Servico pegaPorId(Integer Id){
        return this.servicoRepository.findById(Id).orElseThrow();
    }

    @Transactional
    public Servico cadastro(Servico servico){
        return this.servicoRepository.save(servico);
    }

    @Transactional
    public Servico atualizar(Servico servico, Integer servicoId){
        if(!servico.getId().equals(servicoId)){
            throw new RuntimeException("Id não encontrado");
        }
        this.pegaPorId(servicoId);
        return this.cadastro(servico);
    }
}
