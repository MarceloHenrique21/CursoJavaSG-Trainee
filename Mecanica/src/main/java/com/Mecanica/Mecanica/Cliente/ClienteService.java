package com.Mecanica.Mecanica.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
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


}
