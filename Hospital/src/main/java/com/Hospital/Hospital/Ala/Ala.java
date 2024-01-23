package com.Hospital.Hospital.Ala;

import com.Hospital.Hospital.GerarID.EntityId;
import com.Hospital.Hospital.Quarto.Quarto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ala")
public class Ala extends EntityId {

    @Column(name = "especialidade")
   private String especialidade;

    @JoinColumn(name = "ala_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<Quarto> QuartoList;
}
