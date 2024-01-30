package com.lanchonete.lanchonete.Cliente;

import com.lanchonete.lanchonete.GerarId.GerarId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "cliente")
public class Cliente extends GerarId {

    @Column(name = "nome")
    private String nome;

    @Column(name = "creditos")
    private Integer creditos;
}
