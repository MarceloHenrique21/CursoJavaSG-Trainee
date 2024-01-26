package com.Mecanica.Mecanica.Veiculo;

import com.Mecanica.Mecanica.IdGerador.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "veiculo")
public class Veiculo extends EntityId {

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "anoFabricacao")
    private String anoFabricacao;

    @Column(name = "kmRodados")
    private String kmRodados;
}
