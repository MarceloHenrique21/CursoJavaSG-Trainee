package com.Mecanica.Mecanica.Peca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PecaService {

    private final PecaRepository pecaRepository;

    @Autowired
    public PecaService(PecaRepository pecaRepository){
        this.pecaRepository = pecaRepository;
    }

    @Transactional
    public Peca pegaPorId(Integer Id){
        return this.pecaRepository.findById(Id).orElseThrow();
    }
    @Transactional
    public Peca cadastro(Peca peca){

        int estoque = peca.getQtdeEstoque();
        estoque ++;
        peca.setQtdEstoque(estoque);
        return this.pecaRepository.save(peca);
    }

    @Transactional
    public Peca Atualizar(Peca peca, Integer pecaId){
        if(!peca.getId().equals(pecaId)){
            throw new RuntimeException("Id não encontrado");
        }
        this.pegaPorId(pecaId);
        return this.cadastro(peca);
    }

    @Transactional
    public Peca retirarEstoque(Peca peca, Integer pecaId){
        if(!peca.getId().equals(pecaId)){
            throw new RuntimeException("Id não encontrado");
        }

        this.pegaPorId(pecaId);
        int estoque = peca.getQtdeEstoque();
        estoque --;
        peca.setQtdEstoque(estoque);
        return this.cadastro(peca);
    }

    @Transactional
    public Peca AdicionarEstoque(Peca peca, Integer pecaId){
        if(!peca.getId().equals(pecaId)){
            throw new RuntimeException("Id não encontrado");
        }

        this.pegaPorId(pecaId);
        int estoque = peca.getQtdeEstoque();
        estoque ++;
        peca.setQtdEstoque(estoque);
        return this.cadastro(peca);
    }
}
