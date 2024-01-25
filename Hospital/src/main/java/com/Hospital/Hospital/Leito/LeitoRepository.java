package com.Hospital.Hospital.Leito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Repository
public interface LeitoRepository extends JpaRepository<Leito, Long> {
    Optional<Leito> findById(long id);
    @Query(nativeQuery = true,
            value = "SELECT id, codigo_leito as codigoLeito FROM leitos ",
            countQuery = "SELECT COUNT(*) FROM leitos ")
    Page<LeitoProjection> getLeitosOcupadosPaginado(Pageable pageable);


    @Query(nativeQuery = true,
            value = "SELECT * FROM leitos ",
            countQuery = "SELECT COUNT(*) FROM leitos")
    Page<Leito> getLeitosTestePagina(Pageable pageable);


}
