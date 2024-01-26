package com.Hospital.Hospital.Hospital;

import com.Hospital.Hospital.Ala.Ala;
import com.Hospital.Hospital.DTO.GerarAlaDTO;
import com.Hospital.Hospital.HospitalApplication;
import com.Hospital.Hospital.Leito.Leito;
import com.Hospital.Hospital.Leito.LeitoService;
import com.Hospital.Hospital.Paciente.Paciente;
import com.Hospital.Hospital.Paciente.PacienteRepository;
import com.Hospital.Hospital.Quarto.Quarto;
import com.Hospital.Hospital.Situacao.SituacaoLeito;
import com.Hospital.Hospital.Situacao.SituacaoQuarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    private HospitalRepository hospitalRepository;
    private LeitoService leitoService;
    private PacienteRepository pacienteRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepoitory){
        this.hospitalRepository = hospitalRepoitory;
        this.leitoService = leitoService;
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional
    public Hospital salvar(Hospital hospital){
        return this.hospitalRepository.save(hospital);
    }

    @Transactional
    public Hospital gerarAlas(Hospital hospital) {
        for (Ala ala : hospital.getAlaList()) {
            ala.setQuartoList(gerarQuartos(ala.getQtdeQuartos(), ala.getEspecialidade()));
        }
        return this.hospitalRepository.save(hospital);
    }

    private List<Quarto> gerarQuartos(Integer qtdeQuartos, String especialidade) {
        List<Quarto> quartos = new ArrayList<>();
        for (int i = 1; i <= qtdeQuartos; i++) {
            Quarto quarto = new Quarto();
            quarto.setCodigo(gerarCodigoQuarto(especialidade, i));
            quarto.setStatus(SituacaoQuarto.COMVAGAS); // ou outro status padrão
            quarto.setLeitoList(gerarLeitos(quarto.getCodigo()));
            quartos.add(quarto);
        }
        return quartos;
    }

    private List<Leito> gerarLeitos(String quartoCodigo) {
        List<Leito> leitos = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Leito leito = new Leito();
            leito.setCodigo(quartoCodigo + "-" + i);
            leito.setStatus(SituacaoLeito.LIBERADO);
            leitos.add(leito);
        }
        return leitos;
    }

    private String gerarCodigoQuarto(String especialidade, int numero) {

        String especialidadeAbreviada = abreviarEspecialidade(especialidade);

        String numeroFormatado = String.format("%02d", numero);

        return especialidadeAbreviada + numeroFormatado;
    }

    private String abreviarEspecialidade(String especialidade) {
        especialidade = especialidade.trim().toUpperCase();

        String[] palavras = especialidade.split("\\s+");
        StringBuilder abreviacao = new StringBuilder();
        for (String palavra : palavras) {
            abreviacao.append(palavra.charAt(0));
        }
        return abreviacao.toString();
    }

    public Paciente getPacienteById(Integer pacienteId) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(pacienteId);
        return pacienteOptional.orElse(null);
    }
    @Transactional
    public ResponseEntity<String> internarPaciente(Integer pacienteId, String especialidade) {
        List<Leito> leitosLivres = leitoService.getLeitosLivresPorEspecialidade(especialidade);

        if (!leitosLivres.isEmpty()) {
            Leito leito = leitosLivres.get(0);
            leito.setStatus(SituacaoLeito.OCUPADO);

            Paciente paciente = getPacienteById(pacienteId);

            leito.setPaciente(paciente);

            leito.setDataInternamento(LocalDateTime.now());

            leitoService.saveLeito(leito);

            return ResponseEntity.ok("Paciente internado com sucesso. Código do leito: " + leito.getCodigo());
        } else {
            return ResponseEntity.badRequest().body("Não há leitos disponíveis para a especialidade fornecida.");
        }
    }

    @Transactional
    public ResponseEntity<String> darAlta(Long pacienteId) {
        Optional<Leito> leitoOcupado = leitoService.getLeitoOcupadoPorPacienteId(pacienteId);

        if (leitoOcupado.isPresent()) {
            Leito leito = leitoOcupado.get();

            leito.setDataAlta(LocalDateTime.now());
            leito.setStatus(SituacaoLeito.LIBERADO);

            leitoService.saveLeito(leito);

            return ResponseEntity.ok("Paciente teve alta. Leito liberado.");
        } else {
            return ResponseEntity.badRequest().body("Paciente não encontrado ou não está internado.");
        }
    }

    //public List<Object[]> getInfoPacienteInternadoById(Long pacienteId) {
    //    return hospitalRepository.findInfoPacienteInternadoById(pacienteId);
    //}

    public List<Leito> getLeitosLivresPorEspecialidade(String especialidade) {
        return leitoService.getLeitosLivresPorEspecialidade(especialidade);
    }

    public Quarto getQuartoDoPacienteInternado(Long pacienteId) {
        return leitoService.getQuartoDoPacienteInternado(pacienteId);
    }
}
