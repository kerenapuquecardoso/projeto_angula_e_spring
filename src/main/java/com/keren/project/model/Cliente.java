package com.keren.project.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable= false, length=150)
    private String nome;

    @Column(nullable=false, length=11)
    private String cpf;

    @Column(name= "data_cadastro")
    private LocalDate dataCadastro;
}

