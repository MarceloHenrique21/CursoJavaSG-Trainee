package com.Hospital.Hospital.Paciente;

import com.Hospital.Hospital.GerarID.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "paciente")
public class Paciente extends EntityId {
    @Column(name = "nome")
    private String nome;
}
