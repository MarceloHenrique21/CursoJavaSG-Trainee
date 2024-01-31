package com.Hospital.Hospital.Ala;

import com.Hospital.Hospital.GerarID.EntityId;
import com.Hospital.Hospital.Quarto.Quarto;
import com.Hospital.Hospital.Situacao.SituacaoQuarto;
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

    private Integer qtdeQuartos;

    public void adicionarQuarto(Quarto quarto) {
        QuartoList.add(quarto);
    }

    public void gerarQuartos(Integer qtdeQuartos, Long hospitalId) {
        for (int i = 1; i <= qtdeQuartos; i++) {
            Quarto quarto = new Quarto();
            quarto.setCodigo("QU" + hospitalId + "-" + i);
            quarto.setStatus(SituacaoQuarto.COMVAGAS);
            adicionarQuarto(quarto);
            quarto.gerarLeitos(quarto.getCodigo());
        }
    }
}
