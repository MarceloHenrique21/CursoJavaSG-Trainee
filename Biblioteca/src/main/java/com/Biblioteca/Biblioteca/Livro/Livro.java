package com.Biblioteca.Biblioteca.Livro;

import com.Biblioteca.Biblioteca.EntityID;
import com.Biblioteca.Biblioteca.Pessoa.Pessoa;
import com.Biblioteca.Biblioteca.Situacao.SituacaoLivro;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "livro")
public class Livro extends EntityID {
   @Column(name = "nome")
   private String nome;
   @Column(name = "situacao")
   private SituacaoLivro situacao;
   @Enumerated(EnumType.STRING)
   @Column(name = "situacao_string")
   private SituacaoLivro situacaoString;
   @Column(name = "date")
   private Date date;
   @Column(name = "quantidade_total")
   private int quantidadeTotal;
   @Column(name = "quantidade_disponivel")
   private int quantidadeDisponivel;
   @Column(name = "quantidade_alugada")
   private int quantidadeAlugada;

   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   @JoinColumn(name = "livro_id")
   private List<IdentificadorLivro> identificadorDeLivros = new ArrayList<>();

   public void alteraQuantidadeDeAluguel(int quantidade) {
      this.quantidadeAlugada += quantidade;
      this.quantidadeDisponivel -= quantidade;
   }

   public void alteraQuantidadeDeDevolucao(int quantidade) {
      this.quantidadeAlugada -= quantidade;
      this.quantidadeDisponivel += quantidade;
   }
}

