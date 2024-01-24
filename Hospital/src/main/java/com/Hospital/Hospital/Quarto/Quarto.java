package com.Hospital.Hospital.Quarto;

import com.Hospital.Hospital.GerarID.EntityId;
import com.Hospital.Hospital.Leito.Leito;
import com.Hospital.Hospital.Situacao.SituacaoLeito;
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
    private String codigo;

    @Column(name = "status")
    private SituacaoQuarto status;

    @JoinColumn(name = "quarto_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<Leito> LeitoList;

    public void adicionarLeito(Leito leito) {
        LeitoList.add(leito);
    }

    public void gerarLeitos(String quartoCodigo) {
        for (int i = 1; i <= 2; i++) {
            Leito leito = new Leito();
            leito.setCodigo(quartoCodigo + "-" + i);
            leito.setStatus(SituacaoLeito.LIBERADO);
            adicionarLeito(leito);
        }
    }
}
