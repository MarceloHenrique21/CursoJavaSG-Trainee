package com.Mecanica.Mecanica.Cliente;

import com.Mecanica.Mecanica.IdGerador.EntityId;
import com.Mecanica.Mecanica.Veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "cliente")
public class Cliente extends EntityId {
    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    List<Veiculo> VeiculoList;
}
