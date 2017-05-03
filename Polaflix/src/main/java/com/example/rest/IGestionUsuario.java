package com.example.rest;

import java.util.Date;
import java.util.List;
import com.example.domainModel.Capitulo;
import com.example.domainModel.CapituloVisto;
import com.example.domainModel.EspacioPersonal;
import com.example.domainModel.FacturaCobrada;
import com.example.domainModel.MarcadorSerie;
import com.example.domainModel.Serie;

 interface IGestionUsuario {
	
	List<MarcadorSerie> getSeriesEmpezadas(Long id);
	void anhadeSeriesEmpezadas(Long id, List<MarcadorSerie> series);
	List<Serie> getSeriesPendientes(Long id);
	void anhadeSeriesPendientes(Long id, List<Serie> series);
	List<Serie> getSeriesFinalizadas(Long id);
	void anhadeSeriesFinalizadas(Long id, List<Serie> series);
	List<FacturaCobrada> getFacturas(String nombre);
	FacturaCobrada getFactura(String nombre, Date fecha);
	EspacioPersonal getEspacioPersonal(String nombre);
	List<CapituloVisto> getCapitulosFactura(String nombre, Date fecha);
	void anhadeCapitulosFactura(Long id, List<CapituloVisto> capitulos);	
	void anhadeCapitulos(Long id, List<Capitulo> c);	
}
