package com.lanchonete.lanchonete.Lanchonete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanchoneteRespository extends JpaRepository<Lanchonete, Integer> {
}
