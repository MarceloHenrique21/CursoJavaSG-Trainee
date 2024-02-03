package com.lanchonete.lanchonete.MateriaPrima;

import com.lanchonete.lanchonete.Produtos.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MateriaPrimaService {

    private final MateriaPrimaRepository materiaPrimaRepository;

    @Autowired
    public MateriaPrimaService(MateriaPrimaRepository materiaPrimaRepository) {
        this.materiaPrimaRepository = materiaPrimaRepository;
    }

    @Transactional
    public MateriaPrima cadastrarMateriaPrima(MateriaPrima materiaPrima) {
        validarMateriaPrima(materiaPrima);
        return materiaPrimaRepository.save(materiaPrima);
    }

    public void validarMateriaPrima(MateriaPrima materiaPrima){
        if(materiaPrima.getEstoque() > 0){
            throw new RuntimeException("voce nao pode cadastrar uma materia prima com estoque");
        }
    }

    public void atualizarEstoque(Integer idMateriaPrima, int quantidade) {
       MateriaPrima materiaPrima = materiaPrimaRepository.findById(idMateriaPrima)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        int estoqueAtual = materiaPrima.getEstoque();
        int novoEstoque = estoqueAtual + quantidade;

        if (novoEstoque < 0) {
            throw new IllegalArgumentException("Quantidade de estoque não pode ser negativa");
        }

        materiaPrima.setEstoque(novoEstoque);
        materiaPrimaRepository.save(materiaPrima);
    }
}
