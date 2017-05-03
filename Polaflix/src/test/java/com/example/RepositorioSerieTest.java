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
import com.example.domainModel.Serie;
import com.example.domainModel.Temporada;
import com.example.repositories.SerieRepository;


@SpringBootApplication
@EnableJpaRepositories
/*
 * Ya que es difícil hacer métodos de Test con repositorios, porque no se le puede
 * pasar ningún parámetro, se ha hecho que haya una función que lo pruebe.
 */
public class RepositorioSerieTest {
	
private static final Logger log = LoggerFactory.getLogger(RepositorioSerieTest.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RepositorioSerieTest.class, args);
	}
	
	@Bean
	public CommandLineRunner demoTest(SerieRepository repository) {
		return (args) -> {
			List<Serie> s1 = repository.findByFirstLetter('A');
			List<Temporada> s2 = repository.findTemporadasByIdSerie((long) 1);
			List<Capitulo> s3 = repository.findCapitulosByIdTemporada((long) 1);
			if(s1==null || s2==null || s3==null){
				log.info("Error");
				System.out.println("Error");
			}
		};
	}
}
