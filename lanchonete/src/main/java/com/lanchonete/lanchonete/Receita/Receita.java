package com.lanchonete.lanchonete.Receita;

import com.lanchonete.lanchonete.GerarId.GerarId;
import com.lanchonete.lanchonete.MateriaPrima.MateriaPrima;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "receita")
public class Receita extends GerarId {

    @Column(name = "nomeReceita")
    private String nomeReceita;

    @OneToMany(mappedBy = "receita")
    private List<MateriaPrima> materiaPrimaList;
}
