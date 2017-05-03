package com.example.rest;

import java.util.List;

import com.example.domainModel.Capitulo;
import com.example.domainModel.Serie;
import com.example.domainModel.Temporada;
import com.example.repositories.SerieRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GestionSeries implements IGestionSeries {
	
	SerieRepository rep;

	@RequestMapping("/Serie/{id}")
	@Override
	public Serie getSerieByNombre(@RequestParam(value="nombre") String nombre) {
		return rep.findByNombre(nombre);
	}

	@RequestMapping("/Serie")
	@Override
	public List<Serie> getSeriesByLetter(@RequestParam(value="letra") char letra) {
		return rep.findByFirstLetter(letra);
	}

	@RequestMapping("/Serie/{id}/Temporada")
	@Override
	public List<Temporada> getTemporadasSerie(@RequestParam(value="id") long id) {
		return rep.findTemporadasByIdSerie(id);
	}

	@RequestMapping("/Serie/{id}/Temporada/{id}/Capitulo")
	@Override
	public List<Capitulo> getCapituloTemporada(@RequestParam(value="id") long id) {
		return rep.findCapitulosByIdTemporada(id);
	}
}
