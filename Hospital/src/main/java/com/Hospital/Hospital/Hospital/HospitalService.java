package com.Hospital.Hospital.Hospital;

import com.Hospital.Hospital.DTO.GerarAlaDTO;
import com.Hospital.Hospital.HospitalApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HospitalService {

    private HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepoitory){
        this.hospitalRepository = hospitalRepoitory;
    }

    @Transactional
    public Hospital salvar(Hospital hospital){
        return this.hospitalRepository.save(hospital);
    }

    @Transactional
    public Hospital gerarAlas(Hospital hospital) {
        return this.hospitalRepository.save(hospital);
    }
}
