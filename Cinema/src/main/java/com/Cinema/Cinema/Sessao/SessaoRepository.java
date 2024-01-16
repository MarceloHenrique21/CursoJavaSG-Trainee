package com.Cinema.Cinema.Sessao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM produto WHERE numeroDaSessao ILIKE :numeroDaSessao")
    List<Sessao> findAllBynumeroDaSessao(@Param("numeroDaSessao") Integer numeroDaSessao);
}
