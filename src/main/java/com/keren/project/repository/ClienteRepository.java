package com.keren.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keren.project.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{


}