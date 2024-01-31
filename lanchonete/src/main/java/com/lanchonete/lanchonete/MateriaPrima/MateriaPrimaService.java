package com.lanchonete.lanchonete.MateriaPrima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MateriaPrimaService {

    private MateriaPrimaRepository materiaPrimaRepository;

    @Autowired
    public MateriaPrimaService(MateriaPrimaRepository materiaPrimaRepository){
        this.materiaPrimaRepository = materiaPrimaRepository;
    }

    @Transactional
    public MateriaPrima cadastrarMateriaPrima(MateriaPrima materiaPrima){
        validarMateriaPrima(materiaPrima);
        return this.materiaPrimaRepository.save(materiaPrima);
    }

    public void validarMateriaPrima(MateriaPrima materiaPrima){
        if(materiaPrima.getQtdEstoque() > 0){
            throw new RuntimeException("não é possivel cadastrar um estoque maior que 0");
        }
    }
}
