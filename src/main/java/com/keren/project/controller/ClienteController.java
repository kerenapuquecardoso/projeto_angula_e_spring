package com.keren.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.keren.project.model.Cliente;
import com.keren.project.repository.ClienteRepository;

import jakarta.validation.Valid;

@RequestMapping("/api/clientes")
@RestController
public class ClienteController {
    
    @Autowired
    private ClienteRepository repository;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvarCliente(@RequestBody @Valid Cliente cliente){
        return  repository.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente getById(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        repository.findById(id).map(cliente -> {
            repository.delete(cliente);
            return  Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/")
    public String login(){
        return "Aqui inicializou a API";
    }

   
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Long id, @RequestBody @Valid Cliente clienteModificado){
        repository.findById(id).map(cliente -> {
            cliente.setNome(clienteModificado.getNome());
            cliente.setCpf(clienteModificado.getCpf());
            return  repository.save(clienteModificado);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
