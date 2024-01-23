package com.Biblioteca.Biblioteca.Livro;

import com.Biblioteca.Biblioteca.DTO.GerarIdentificadoresDTO;
import com.Biblioteca.Biblioteca.Pessoa.PessoaService;
import com.Biblioteca.Biblioteca.Situacao.SituacaoLivro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class LivroService {
    private final LivroRepository livroRepository;
    private final PessoaService pessoaService;

    @Autowired
    public LivroService(LivroRepository livroRepository,
                        PessoaService pessoaService) {
        this.livroRepository = livroRepository;
        this.pessoaService = pessoaService;
    }

    @Transactional(readOnly = true)
    public Livro pegarPorId(Integer id) {
        return this.livroRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Livro salvar(Livro livro) {
        this.validarLivro(livro);
        return this.livroRepository.save(livro);
    }

    public void validarLivro(Livro livro) {
        if (Objects.isNull(livro.getNome())
                || livro.getNome().isEmpty()) {
            throw new RuntimeException("Livro sem nome");
        }
        if (Objects.isNull(livro.getSituacao())) {
            throw new RuntimeException("Livro sem situação");
        }
        if (Objects.isNull(livro.getDate())) {
            throw new RuntimeException("Livro sem data de cadastro");
        }
        if (Objects.isNull(livro.getQuantidadeTotal())) {
            throw new RuntimeException("Livro sem quantidade total");
        }
        if (Objects.isNull(livro.getQuantidadeDisponivel())
                || (livro.getQuantidadeTotal() != livro.getQuantidadeDisponivel())) {
            throw new RuntimeException("Livro com quantidade disponível invalida");
        }
        if (livro.getQuantidadeAlugada() != 0) {
            throw new RuntimeException("Livro com quantidade alugada invalida");
        }
        if (livro.getQuantidadeTotal() > 0) {
            if ((Objects.isNull(livro.getIdentificadorDeLivros())
                    ||  livro.getIdentificadorDeLivros().size() != livro.getQuantidadeTotal())) {
                throw new RuntimeException("Livro com lista de identificadores invalida");
            }
        }

        if (Objects.nonNull(livro.getIdentificadorDeLivros())) {
            livro.getIdentificadorDeLivros().forEach(iden -> {
                if (Objects.isNull(iden.getNumero())) {
                    throw new RuntimeException("Iden sem número");
                }
                if (Objects.nonNull(iden.getPessoaId())) {
                    throw new RuntimeException("Livro já alugado, não pode.");
                }
            });
        }
    }

    @Transactional(readOnly = true)
    public List<Livro> getPorOrdemAlfabetica() {
        List<Livro> livros = this.livroRepository.findAll();
        livros.sort(Comparator.comparing(Livro::getNome));
        return livros;
    }

    @Transactional(readOnly = true)
    public List<Livro> getByNomeContainsIgnoreCase(String nome) {
        return this.livroRepository.getByNomeContainsIgnoreCase("%" + nome + "%");
    }

    @Transactional(readOnly = true)
    public List<Livro> getOndeTemDisponivel() {
        List<Livro> livros = this.livroRepository.findAll();
        livros = livros
                .stream()
                .filter(livro -> livro.getQuantidadeDisponivel() > 0)
                .toList();
        return livros;
    }

    @Transactional
    public void alugaLivros(List<AlugaEDevolveLivros> dtos, Integer pessoaId) {
        if (Objects.isNull(dtos)) {
            throw new RuntimeException("DTO nulo");
        }
        this.pessoaService.pegarPessoaPorId(pessoaId);
        dtos.forEach(dto -> {
            Livro livro = this.livroRepository
                    .findById(dto.getLivroId())
                    .orElseThrow(RuntimeException::new);

            if (livro.getSituacao().equals(SituacaoLivro.INATIVO)) {
                throw new RuntimeException("Livro inativo");
            }

            List<IdentificadorLivro> identificadoresDeLivros = livro.getIdentificadorDeLivros()
                    .stream()
                    .filter(idem -> dto.getNumeros().contains(idem.getNumero())
                            && Objects.isNull(idem.getPessoaId()))
                    .toList();

            if (identificadoresDeLivros.size() != dto.getNumeros().size()) {
                throw new RuntimeException("Algum livro não está disponível ");
            }

            identificadoresDeLivros.forEach(idem -> {
                idem.setPessoaId(pessoaId);
            });

            livro.alteraQuantidadeDeAluguel(dto.getNumeros().size());
            this.livroRepository.save(livro);
        });
    }


    @Transactional
    public void deletarLivro(Integer livroId) {
        Livro livro = this.pegarPorId(livroId);
        if (livro.getQuantidadeAlugada() > 0) {
            throw new RuntimeException("Não pode deletar livro alugado");
        }
        livro.getIdentificadorDeLivros().forEach(idem -> {
            if (Objects.nonNull(idem.getPessoaId())) {
                throw new RuntimeException("Livro alugado");
            }
        });
        this.livroRepository.deleteById(livroId);
    }

    @Transactional
    public void devolveLivros(List<AlugaEDevolveLivros> dtos) {
        if (Objects.isNull(dtos)) {
            throw new RuntimeException("DTO nulo");
        }
        dtos.forEach(dto -> {
            Livro livro = this.livroRepository
                    .findById(dto.getLivroId())
                    .orElseThrow(RuntimeException::new);

            List<IdentificadorLivro> identificadoresDeLivros = livro.getIdentificadorDeLivros()
                    .stream()
                    .filter(idem -> dto.getNumeros().contains(idem.getNumero())
                            && Objects.nonNull(idem.getPessoaId()))
                    .toList();

            if (identificadoresDeLivros.size() != dto.getNumeros().size()) {
                throw new RuntimeException("Algum livro não está disponível ");
            }

            identificadoresDeLivros.forEach(idem -> {
                idem.setPessoaId(null);
            });

            livro.alteraQuantidadeDeDevolucao(dto.getNumeros().size());
            this.livroRepository.save(livro);
        });
    }

    @Transactional
    public Livro gerarIdentificadoresDeLivros(GerarIdentificadoresDTO dto) {
        Livro livro = this.pegarPorId(dto.getLivroId());
        if (Objects.isNull(livro.getIdentificadorDeLivros())) {
            livro.setIdentificadorDeLivros(new ArrayList<>());
        }
        for (int i = 1; i <= dto.getQuantidadeTotal(); i++) {
            livro.getIdentificadorDeLivros()
                    .add(new IdentificadorLivro(i + livro.getQuantidadeTotal()));
        }
        livro.setQuantidadeTotal(livro.getQuantidadeTotal() + dto.getQuantidadeTotal());
        livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() + dto.getQuantidadeTotal());
        return this.livroRepository.save(livro);
    }
}
