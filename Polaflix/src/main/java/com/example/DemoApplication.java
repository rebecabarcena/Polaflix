package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.repositories.SerieRepository;

@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(SerieRepository repository) {
		return (args) -> {
			repository.findCapitulosByIdTemporada((long) 1);
			//log.info(repository.findSeriesEmpezadasByEP(i).toString());
		};
	}
}
