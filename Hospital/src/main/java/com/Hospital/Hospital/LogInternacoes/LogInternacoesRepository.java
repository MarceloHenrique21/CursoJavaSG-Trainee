package com.Hospital.Hospital.LogInternacoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogInternacoesRepository extends JpaRepository<LogInternacoes, Long> {

}
