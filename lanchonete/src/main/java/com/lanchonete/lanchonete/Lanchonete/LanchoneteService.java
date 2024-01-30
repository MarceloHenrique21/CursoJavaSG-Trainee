package com.lanchonete.lanchonete.Lanchonete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LanchoneteService {

    private LanchoneteRespository lanchoneteRespository;

    @Autowired
    public LanchoneteService(LanchoneteRespository lanchoneteRespository){
        this.lanchoneteRespository = lanchoneteRespository;
    }

    @Transactional
    public Lanchonete cadastrarLanchonete(Lanchonete lanchonete){
       return this.lanchoneteRespository.save(lanchonete);
    }
}
