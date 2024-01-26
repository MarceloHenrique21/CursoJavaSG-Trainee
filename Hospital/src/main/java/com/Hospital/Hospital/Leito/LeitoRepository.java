package com.Hospital.Hospital.Leito;

import com.Hospital.Hospital.Quarto.Quarto;
import com.Hospital.Hospital.Situacao.SituacaoLeito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeitoRepository extends JpaRepository<Leito, Long> {
    Optional<Leito> findById(long id);

    Optional<Leito> findByPacienteIdAndStatus(Long pacienteId, SituacaoLeito status);

    @Query(nativeQuery = true,
            value = "SELECT id, codigo_leito as codigoLeito FROM leitos ",
            countQuery = "SELECT COUNT(*) FROM leitos ")
    Page<LeitoProjection> getLeitosOcupadosPaginado(Pageable pageable);

    @Query(nativeQuery = true,
            value = "SELECT * FROM leitos ",
            countQuery = "SELECT COUNT(*) FROM leitos")
    Page<Leito> getLeitosTestePagina(Pageable pageable);

    @Query("SELECT l FROM Leito l " +
            "JOIN l.quarto q " +
            "JOIN q.ala a " +
            "WHERE a.especialidade = :especialidade AND l.status = 'LIBERADO'")
    List<Leito> findLeitosLivresPorEspecialidade(@Param("especialidade") String especialidade);

    @Query("SELECT q FROM Quarto q " +
            "JOIN q.leito l " +
            "JOIN l.paciente p " +
            "WHERE p.id = :pacienteId")
    Quarto findQuartoDoPacienteInternado(@Param("pacienteId") Long pacienteId);

    @Query("SELECT l FROM Leito l")
    List<Leito> findAllLeitos();

    @Query("SELECT a.especialidade, COUNT(q) AS totalQuartos, " +
            "SUM(CASE WHEN q.status = 'COMVAGAS' THEN 1 ELSE 0 END) AS quartosLivres, " +
            "SUM(CASE WHEN q.status = 'SEMVAGAS' THEN 1 ELSE 0 END) AS quartosOcupados " +
            "FROM Ala a " +
            "JOIN a.quarto q " +
            "GROUP BY a.especialidade")
    List<Object[]> countQuartosPorEspecialidade();
}
