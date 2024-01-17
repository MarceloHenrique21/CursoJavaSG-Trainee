package com.Cinema.Cinema.Pessoa;

import com.Cinema.Cinema.Assentos.Assentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Assentos, String> {

}

