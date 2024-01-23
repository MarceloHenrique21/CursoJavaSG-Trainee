package com.Hospital.Hospital.Hospital;

import com.Hospital.Hospital.Ala.Ala;
import com.Hospital.Hospital.GerarID.EntityId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "hospital")
public class Hospital extends EntityId {

    @Column(name = "nome")
    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ala_id")
    List<Ala> AlaList;
}
