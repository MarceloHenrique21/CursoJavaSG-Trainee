package com.Mecanica.Mecanica.Cliente;

import com.Mecanica.Mecanica.DTO.CriarOrdemServicoDTO;
import com.Mecanica.Mecanica.OrdemServico.OrdemServico;
import com.Mecanica.Mecanica.OrdemServico.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final OrdemServicoRepository ordemServicoRepository;
    @Autowired
    public ClienteService(ClienteRepository clienteRepository, OrdemServicoRepository ordemServicoRepository){
        this.clienteRepository = clienteRepository;
        this.ordemServicoRepository = ordemServicoRepository;
    }

    @Transactional
    public Cliente pegaPorId(Integer id){
        return this.clienteRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Cliente cadastro (Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    public Cliente Atualizar (Cliente cliente, Integer clienteId){
        if(!cliente.getId().equals(clienteId)){
            throw new RuntimeException("Id não encontrado");
        }

        this.pegaPorId(clienteId);
        return this.cadastro(cliente);
    }

//    public OrdemServico ordemServico(CriarOrdemServicoDTO criarOrdemServicoDTO){
//
//        return
//    }

}
