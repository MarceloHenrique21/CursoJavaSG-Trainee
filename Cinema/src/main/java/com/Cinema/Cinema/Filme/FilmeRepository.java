package com.Cinema.Cinema.Filme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    // Consulta personalizada para encontrar produtos por nome (ignorando maiúsculas/minúsculas)
    @Query(nativeQuery = true,
            value = "SELECT * FROM produto WHERE nome ILIKE :nome")
    List<Filme> findAllByNome(@Param("nome") String nome);
}
