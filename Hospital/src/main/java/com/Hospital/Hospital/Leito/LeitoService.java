package com.Hospital.Hospital.Leito;


import com.Hospital.Hospital.DTO.LeitoProjectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class LeitoService {

    private LeitoRepository leitoRepository;

    @Autowired
    public LeitoService(LeitoRepository leitoRepository){
        this.leitoRepository = leitoRepository;
    }

    public Page<LeitoProjectionDTO> getLeitosOcupados(Pageable pageable) {
        Page<LeitoProjection> leitoProjections =  this.leitoRepository.getLeitosOcupadosPaginado(pageable);
        List<LeitoProjectionDTO> leitoProjectionDTOList = leitoProjections
                .getContent().stream().map(p -> {
                    return new LeitoProjectionDTO(p);
                }).toList();
        return new PageImpl<>(leitoProjectionDTOList, pageable, leitoProjections.getTotalElements());
    }

    public Page<Leito> getLeitosOcupadosTeste(Pageable pageable) {

        Page<Leito> pageLeitos = this.leitoRepository.getLeitosTestePagina(pageable);
        return this.leitoRepository.getLeitosTestePagina(pageable);
    }
}
