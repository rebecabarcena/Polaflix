package com.example.rest;

import java.util.Date;
import java.util.List;
import com.example.domainModel.Capitulo;
import com.example.domainModel.CapituloVisto;
import com.example.domainModel.EspacioPersonal;
import com.example.domainModel.FacturaCobrada;
import com.example.domainModel.MarcadorSerie;
import com.example.domainModel.Serie;
import com.example.domainModel.Usuario;

 interface IGestionUsuario {
	
	List<MarcadorSerie> getSeriesEmpezadas(Long id);
	Usuario anhadeSeriesEmpezadas(String nombre, Long id, String serie);
	List<Serie> getSeriesPendientes(Long id);
	Usuario anhadeSeriesPendientes(String nombre, Long id, String series);
	List<Serie> getSeriesFinalizadas(Long id);
	List<FacturaCobrada> getFacturas(String nombre);
	List<Capitulo> getCapitulosVistos(Long id);
	EspacioPersonal getEspacioPersonal(String nombre);
	Usuario verCapitulo(String nombre, String c);	
	Usuario capituloVisto(String nombre, Long id, String c);	
}
