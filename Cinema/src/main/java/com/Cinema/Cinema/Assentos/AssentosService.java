package com.Cinema.Cinema.Assentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssentosService {
    private final AssentoRepository assentoRepository;

    @Autowired
    public AssentosService(AssentoRepository assentoRepository){
        this.assentoRepository = assentoRepository;
    }

    @Transactional
    public Assentos cadastrarAssentos(Assentos assentos){
        return this.assentoRepository.save(assentos);
    }


}
