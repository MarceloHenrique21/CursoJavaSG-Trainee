package com.Hospital.Hospital.Leito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeitoRepository extends JpaRepository<Leito, Long> {
    Optional<Leito> findById(long id);
}
