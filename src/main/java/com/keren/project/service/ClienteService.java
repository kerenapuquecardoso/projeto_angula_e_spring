package com.keren.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keren.project.model.Cliente;
import com.keren.project.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository meuRepository;

    private void validarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
