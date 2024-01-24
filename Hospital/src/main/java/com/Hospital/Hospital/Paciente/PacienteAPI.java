package com.Hospital.Hospital.Paciente;

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
@RequestMapping("/api/pacientes")
public class PacienteAPI {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/internar")
    public ResponseEntity<String> internarPaciente(@RequestBody InternarPacienteDTO internarPacienteDTO) {
        Paciente paciente = internarPacienteDTO.getPaciente();
        Ala ala = internarPacienteDTO.getAla();

        pacienteService.internarPaciente(paciente, ala);

        return ResponseEntity.ok("Paciente internado com sucesso.");
    }

    @PostMapping("/dar-alta")
    public ResponseEntity<String> darAltaPaciente(@RequestParam Long leitoId) {
        Leito leito = LeitoRepository.findById(leitoId)
                .orElseThrow(() -> new RuntimeException("Leito não encontrado"));

        pacienteService.darAltaPaciente(leito);

        return ResponseEntity.ok("Paciente teve alta com sucesso.");
    }

    // Outros métodos e endpoints relacionados aos pacientes...
}
