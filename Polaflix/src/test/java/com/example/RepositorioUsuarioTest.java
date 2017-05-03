package com.example;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.domainModel.Capitulo;
import com.example.domainModel.FacturaCobrada;
import com.example.domainModel.Serie;
import com.example.domainModel.Temporada;
import com.example.repositories.SerieRepository;
import com.example.repositories.UsuarioRepository;


@SpringBootApplication
@EnableJpaRepositories
/*
 * Ya que es difícil hacer métodos de Test con repositorios, porque no se le puede
 * pasar ningún parámetro, se ha hecho que haya una función que lo pruebe.
 */
public class RepositorioUsuarioTest {
	
private static final Logger log = LoggerFactory.getLogger(RepositorioUsuarioTest.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RepositorioUsuarioTest.class, args);
	}
	
	@Bean
	public CommandLineRunner demoTest(UsuarioRepository repository) {
		return (args) -> {
			List<Capitulo> u1 = repository.findVisualizacionesByFacturaCobrada((long) 1);
			List<FacturaCobrada> fs = repository.findFacturasCobradas("pepito");
			
		};
	}
}
