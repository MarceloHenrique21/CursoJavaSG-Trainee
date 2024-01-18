package com.Cinema.Cinema.Filme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM Filme WHERE nome ILIKE :nome")
    List<Filme> findAllByNome(@Param("nome") String nome);
}
