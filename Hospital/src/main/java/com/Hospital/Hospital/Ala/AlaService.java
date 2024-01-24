package com.Hospital.Hospital.Ala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlaService {

    private AlaRepository alaRepository;

    @Autowired
    public AlaService(AlaRepository alaRepository){
        this.alaRepository = alaRepository;
    }

    @Transactional
    public Ala salvar(Ala ala){
        return this.alaRepository.save(ala);
    }
}
