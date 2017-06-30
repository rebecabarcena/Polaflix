package com.example.rest;

import java.util.List;

import com.example.domainModel.Capitulo;
import com.example.domainModel.Serie;
import com.example.domainModel.Temporada;
import com.example.repositories.SerieRepository;
import com.example.rest.IGestionSeries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GestionSeries implements IGestionSeries {
	
	@Autowired
	SerieRepository rep;
	
	@Autowired
	GestionSeries(SerieRepository rep){
		this.rep = rep;
	}

	@RequestMapping("/Serie/{id}/Temporada")
	@Override
	public List<Temporada> getTemporadasSerie(@PathVariable("id") Long id) {
		return rep.findTemporadasByIdSerie(id);
	}

	@RequestMapping("/Serie/{id}/Temporada/{idTemporada}/Capitulo")
	@Override
	public List<Capitulo> getCapituloTemporada(@PathVariable("idTemporada") Long idTemporada) {
		return rep.findCapitulosByIdTemporada(idTemporada);
	}
	
	@RequestMapping("/Serie")
	@Override
	public List<Serie> getSeries(){
		return rep.findSeries();
	}
}
