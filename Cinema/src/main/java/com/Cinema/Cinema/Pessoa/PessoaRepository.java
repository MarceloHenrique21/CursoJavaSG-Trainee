package com.Cinema.Cinema.Pessoa;

import com.Cinema.Cinema.Filme.Filme;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, String> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM Pessoa WHERE nome ILIKE :nome")
    List<Pessoa> findAllByNome(@Param("nome") String nome);
}

