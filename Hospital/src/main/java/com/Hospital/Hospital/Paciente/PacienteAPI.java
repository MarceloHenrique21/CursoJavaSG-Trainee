package com.Hospital.Hospital.Paciente;

import com.Hospital.Hospital.Hospital.Hospital;
import com.Hospital.Hospital.Hospital.HospitalService;
import com.Hospital.Hospital.Leito.LeitoRepository;
import com.Hospital.Hospital.Situacao.SituacaoLeito;
import com.Hospital.Hospital.Situacao.SituacaoQuarto;
import com.Hospital.Hospital.Ala.Ala;
import com.Hospital.Hospital.Leito.Leito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Hospital.Hospital.Paciente.InternarPacienteDTO;
@RestController
@RequestMapping("/paciente")
public class PacienteAPI {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteAPI(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(this.pacienteService.salvar(paciente));
    }

    @PostMapping("/internar")
    public ResponseEntity<String> internarPaciente(@RequestBody InternarPacienteDTO internarPacienteDTO) {
        Paciente paciente = internarPacienteDTO.getPaciente();
        Ala ala = internarPacienteDTO.getAla();

        pacienteService.internarPaciente(paciente, ala);
        return ResponseEntity.ok("Paciente internado com sucesso.");
    }
}
