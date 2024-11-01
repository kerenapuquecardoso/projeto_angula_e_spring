package com.keren.project.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable= false, length=150)
    @NotEmpty
    private String nome;

    @Column(nullable=false, length=11)
    @CPF
    private String cpf;

    @Column(name= "data_cadastro", updatable = false)
    @JsonFormat(pattern= "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersistir(){
        setDataCadastro(LocalDate.now());
    }
}

