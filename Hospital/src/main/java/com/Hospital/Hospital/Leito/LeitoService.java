package com.Hospital.Hospital.Leito;


import com.Hospital.Hospital.DTO.LeitoProjectionDTO;
import com.Hospital.Hospital.Quarto.Quarto;
import com.Hospital.Hospital.Situacao.SituacaoLeito;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class LeitoService {

    private LeitoRepository leitoRepository;

    @Autowired
    public LeitoService(LeitoRepository leitoRepository){
        this.leitoRepository = leitoRepository;
    }



    @Transactional
    public Leito saveLeito(Leito leito) {
        return leitoRepository.save(leito);
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

    public List<Leito> getLeitosLivresPorEspecialidade(String especialidade) {
        return leitoRepository.findLeitosLivresPorEspecialidade(especialidade);
    }

    public Quarto getQuartoDoPacienteInternado(Long pacienteId) {
        return leitoRepository.findQuartoDoPacienteInternado(pacienteId);
    }

    public List<Leito> getAllLeitos() {
        return leitoRepository.findAllLeitos();
    }

    public List<Object[]> countQuartosPorEspecialidade() {
        return leitoRepository.countQuartosPorEspecialidade();
    }

    public Optional<Leito> getLeitoOcupadoPorPacienteId(Long pacienteId) {
        return leitoRepository.findByPacienteIdAndStatus(pacienteId, SituacaoLeito.OCUPADO);
    }
}
