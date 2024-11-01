package com.keren.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.keren.project.model.Cliente;
import com.keren.project.repository.ClienteRepository;

@SpringBootApplication
public class ProjectApplication {

	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository repository){
		return  args -> {
			Cliente cliente =  Cliente.builder().nome("Keren").cpf("12345678945").build();
			repository.save(cliente);
			
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
