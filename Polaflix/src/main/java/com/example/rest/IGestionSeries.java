package com.example.rest;

import java.util.List;

import com.example.domainModel.Capitulo;
import com.example.domainModel.Serie;
import com.example.domainModel.Temporada;

public interface IGestionSeries {

	public Serie getSerieByNombre(String nombre);
	public List<Serie> getSeriesByLetter(char letra);
	public List<Temporada> getTemporadasSerie(long id);
	public List<Capitulo> getCapituloTemporada(long id);
}
