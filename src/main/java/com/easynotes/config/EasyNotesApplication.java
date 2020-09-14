package com.easynotes.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.easynotes")
@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories("com.easynotes.repository")
@EntityScan("com.easynotes.model")
public class EasyNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyNotesApplication.class, args);
	}

}
