package com.Hospital.Hospital.Paciente;

import com.Hospital.Hospital.Ala.Ala;
import com.Hospital.Hospital.Hospital.Hospital;
import com.Hospital.Hospital.Leito.Leito;
import com.Hospital.Hospital.Leito.LeitoRepository;
import com.Hospital.Hospital.LogInternacoes.LogInternacoes;
import com.Hospital.Hospital.LogInternacoes.LogInternacoesRepository;
import com.Hospital.Hospital.Quarto.Quarto;
import com.Hospital.Hospital.Situacao.SituacaoLeito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class PacienteService {

    private LeitoRepository leitoRepository;
    private PacienteRepository pacienteRepository;
    private LogInternacoesRepository logInternacoesRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, LeitoRepository leitoRepository, LogInternacoesRepository logInternacoesRepository){
        this.pacienteRepository = pacienteRepository;
        this.leitoRepository = leitoRepository;
        this.logInternacoesRepository = logInternacoesRepository;
    }
    @Transactional
    public Paciente salvar(Paciente paciente){
        return this.pacienteRepository.save(paciente);
    }

    public void internarPaciente(Paciente paciente, Ala ala) {
        Leito leitoDisponivel = encontrarLeitoDisponivel(ala);

        if (leitoDisponivel != null) {
            leitoDisponivel.setStatus(SituacaoLeito.OCUPADO);
            leitoDisponivel.setPacienteId(paciente.getId());

            LogInternacoes logInternacoes = new LogInternacoes();
            logInternacoes.setDataInternamento(new Date());
            logInternacoes.setLeito(leitoDisponivel);

            leitoDisponivel.getLogInternacoesList().add(logInternacoes);

            leitoRepository.save(leitoDisponivel);
            logInternacoesRepository.save(logInternacoes);

        } else {
            throw new RuntimeException("Não há leitos disponíveis na ala " + ala.getEspecialidade());
        }
    }

    private Leito encontrarLeitoDisponivel(Ala ala) {
        for (Quarto quarto : ala.getQuartoList()) {
            for (Leito leito : quarto.getLeitoList()) {
                if (leito.getStatus() == SituacaoLeito.LIBERADO) {
                    return leito;
                }
            }
        }
        return null;
    }
}
