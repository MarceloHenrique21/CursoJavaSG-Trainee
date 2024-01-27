package com.Cinema.Cinema.Pessoa;

import com.Cinema.Cinema.Assentos.AssentoRepository;
import com.Cinema.Cinema.Assentos.Assentos;
import com.Cinema.Cinema.Sessao.Sessao;
import com.Cinema.Cinema.Sessao.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final SessaoRepository sessaoRepository;
    private final AssentoRepository assentoRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository, SessaoRepository sessaoRepository, AssentoRepository assentoRepository){
        this.pessoaRepository = pessoaRepository;
        this.sessaoRepository = sessaoRepository;
        this.assentoRepository = assentoRepository;
    }

    @Transactional
    public Pessoa cadastrarPessoa (Pessoa pessoa){
        return this.pessoaRepository.save(pessoa);
    }

    @Transactional
    public List<Pessoa> buscarNome(String nome){
        return this.pessoaRepository.findAllByNome("%" + nome + "%");
    }


    public ResponseEntity<String> comprarAssento(Integer pessoaId, Integer sessaoId, List<Integer> numerosAssentos) {
        Pessoa pessoa = pessoaRepository.getById(pessoaId);
        Sessao sessao = sessaoRepository.getById(sessaoId);

        if (pessoa != null && sessao != null) {
            for (Integer numeroAssento : numerosAssentos) {
                Assentos assento = assentoRepository.findBySessaoAndNumero(sessao, numeroAssento);

                if (assento == null || !assento.isDisponivel()) {
                    return ResponseEntity.badRequest().body("O assento " + numeroAssento + " na sessão " + sessaoId + " não está disponível.");
                }
            }

            for (Integer numeroAssento : numerosAssentos) {
                Assentos assento = assentoRepository.findBySessaoAndNumero(sessao, numeroAssento);
                assento.setDisponivel(false);
                assentoRepository.save(assento);

                pessoa.getAssentosList().add(assento);
            }

            pessoaRepository.save(pessoa);

            return ResponseEntity.ok("Ingresso(s) comprado(s) com sucesso.");
        } else {
            return ResponseEntity.notFound().body("Pessoa ou sessão não encontrada.");
        }
    }
}
