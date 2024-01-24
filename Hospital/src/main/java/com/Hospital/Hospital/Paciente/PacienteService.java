package com.Hospital.Hospital.Paciente;

import com.Hospital.Hospital.Ala.Ala;
import com.Hospital.Hospital.Leito.Leito;
import com.Hospital.Hospital.Leito.LeitoRepository;
import com.Hospital.Hospital.LogInternacoes.LogInternacoes;
import com.Hospital.Hospital.LogInternacoes.LogInternacoesRepository;
import com.Hospital.Hospital.Quarto.Quarto;
import com.Hospital.Hospital.Situacao.SituacaoLeito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private LeitoRepository leitoRepository;

    @Autowired
    private LogInternacoesRepository logInternacoesRepository;

    // ... outros métodos

    public void internarPaciente(Paciente paciente, Ala ala) {
        Leito leitoDisponivel = encontrarLeitoDisponivel(ala);

        if (leitoDisponivel != null) {
            leitoDisponivel.setStatus(SituacaoLeito.OCUPADO);
            leitoDisponivel.setPacienteId(paciente.getId());

            // Criar uma instância de LogInternacoes e associá-la ao Leito
            LogInternacoes logInternacoes = new LogInternacoes();
            logInternacoes.setDataInternamento(new Date());
            logInternacoes.setLeito(leitoDisponivel);  // Associar o LogInternacoes ao Leito

            leitoDisponivel.getLogInternacoesList().add(logInternacoes);  // Adicionar LogInternacoes à lista do Leito

            leitoRepository.save(leitoDisponivel);

            // Salvar o registro de log no banco de dados
            logInternacoesRepository.save(logInternacoes);

            // Pode ser necessário atualizar o status do quarto ou ala dependendo dos requisitos do seu sistema
        } else {
            throw new RuntimeException("Não há leitos disponíveis na ala " + ala.getEspecialidade());
        }
    }

    private Leito encontrarLeitoDisponivel(Ala ala) {
        // Implementar lógica para encontrar um leito disponível na ala de acordo com a especialidade
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
