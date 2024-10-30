package com.keren.project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	@Value("${spring.application.name}")
	private static String applicationName;
	
	
	public static void main(String[] args) {
		System.out.println(applicationName);
		SpringApplication.run(ProjectApplication.class, args);
	}

}
