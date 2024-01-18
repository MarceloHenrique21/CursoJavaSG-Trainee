
package com.semanaDois.semanaDois.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<com.semanaDois.semanaDois.Produto.Produto, Integer> {

    // Consulta personalizada para encontrar produtos por nome (ignorando maiúsculas/minúsculas)
    @Query(nativeQuery = true,
            value = "SELECT * FROM produto WHERE nome ILIKE :nome")
    List<com.semanaDois.semanaDois.Produto.Produto> findAllByNome(@Param("nome") String nome);
}
