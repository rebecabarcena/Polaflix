package com.example.rest;

import java.util.List;

import com.example.domainModel.Capitulo;
import com.example.domainModel.Serie;
import com.example.domainModel.Temporada;

public interface IGestionSeries {

	public List<Temporada> getTemporadasSerie(Long id);
	public List<Capitulo> getCapituloTemporada(Long id);
	public List<Serie> getSeries();
}
