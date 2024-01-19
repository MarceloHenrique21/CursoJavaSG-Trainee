package com.Cinema.Cinema.Assentos;

import com.Cinema.Cinema.Sessao.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssentoRepository extends JpaRepository<Assentos, Integer> {

    Assentos findBySessaoAndNumero(Sessao sessao, Integer numero);
}
