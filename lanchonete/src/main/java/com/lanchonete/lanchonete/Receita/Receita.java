package com.lanchonete.lanchonete.Receita;

import com.lanchonete.lanchonete.GerarId.GerarId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "receita")
public class Receita extends GerarId {

    @Column(name = "nomeReceita")
    private String nomeReceita;
}
