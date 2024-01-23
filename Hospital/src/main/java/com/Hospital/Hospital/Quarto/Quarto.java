package com.Hospital.Hospital.Quarto;

import com.Hospital.Hospital.GerarID.EntityId;
import com.Hospital.Hospital.Leito.Leito;
import com.Hospital.Hospital.Situacao.SituacaoQuarto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "quarto")
public class Quarto extends EntityId {
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "status")
    private SituacaoQuarto status;

    @JoinColumn(name = "quarto_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<Leito> LeitoList;
}
