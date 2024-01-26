package com.Hospital.Hospital.Hospital;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
   /* @Query("SELECT h.nome AS Hospital, a.especialidade, q.codigo AS codigoQuarto, " +
            "p.nome AS nomePaciente, li.dataInternamento " +
            "FROM Hospital h " +
            "JOIN h.alas a " +
            "JOIN a.quarto q " +
            "JOIN q.leito l " +
            "JOIN l.paciente p " +
            "JOIN LogInternacoes li ON li.leito.id = l.id " +
            "WHERE p.id = :pacienteId AND li.dataAlta IS NULL")
    List<Object[]> findInfoPacienteInternadoById(@Param("pacienteId") Long pacienteId);
*/
}
