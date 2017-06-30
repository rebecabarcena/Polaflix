package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.domainModel.Capitulo;
import com.example.domainModel.Serie;
import com.example.domainModel.Temporada;

/**
 * Repositorio para las series
 * Al igual que con el repositorio de los usuarios, podrían emplearse
 * repositorios "page and sort", aunque tratan de evitarse si van a
 * usarse servicios REST, por lo que en estas implementaciones no se
 * van a utilizar
 * @author Rebeca Bárcena Orero
 */
public interface SerieRepository extends JpaRepository<Serie, Long>{

	Serie findByNombre(String nombre);
	
	@Query("select s from Serie s where s.nombre like ?1%")	
	List<Serie> findByFirstLetter(char firstLetter);	
	
	@Query("select s from Serie s")	
	List<Serie> findSeries();	

	@Query("select s.temporadas from Serie s where s.id = ?1")
	List<Temporada> findTemporadasByIdSerie(Long id);
	
	@Query("select t.capitulos from Temporada t where t.id = ?1")
	List<Capitulo> findCapitulosByIdTemporada(Long idTemporada);
	
	@Query("select c from Capitulo c where c.id = ?1")
	List<Capitulo> findCapituloById(Long idCapitulo);
}
