package com.example.rest;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domainModel.Capitulo;
import com.example.domainModel.CapituloVisto;
import com.example.domainModel.EspacioPersonal;
import com.example.domainModel.FacturaCobrada;
import com.example.domainModel.MarcadorSerie;
import com.example.domainModel.Serie;
import com.example.repositories.UsuarioRepository;

@RestController
public class GestionUsuario implements IGestionUsuario{
	
	private UsuarioRepository rep;
	
	@RequestMapping("/Usuario/{nombre}/EspacioPersonal/{id}/SeriesEmpezadas")
	@Override
	public List<MarcadorSerie> getSeriesEmpezadas(@RequestParam(value="id") Long id) {
		return rep.findSeriesEmpezadasByEP(id);
	}
	
	@RequestMapping("/Usuario/{nombre}/EspacioPersonal/{id}/SeriesEmpezadas/{id}")
	@Override
	public void anhadeSeriesEmpezadas(@RequestParam(value="id") Long id,
			@RequestParam(value="series") List<MarcadorSerie> series) {
		rep.setUsuarioSeriesEmpezadas(id, series);
	}

	@RequestMapping("/Usuario/{nombre}/EspacioPersonal/{id}/SeriesPendientes")
	@Override
	public List<Serie> getSeriesPendientes(@RequestParam(value="id") Long id) {
		return rep.findSeriesPendientesByEP(id);
	}

	@RequestMapping("/Usuario/{nombre}/EspacioPersonal/{id}/SeriesPendientes/{id}")
	@Override
	public void anhadeSeriesPendientes(@RequestParam(value="id") Long id,
			@RequestParam(value="series") List<Serie> series) {
		rep.setUsuarioSeriesPendientes(id, series);
	}

	@RequestMapping("/Usuario/{nombre}/EspacioPersonal/{id}/SeriesFinalizadas")
	@Override
	public List<Serie> getSeriesFinalizadas(@RequestParam(value="id") Long id) {
		return rep.findSeriesFinalizadasByEP(id);
	}

	@RequestMapping("/Usuario/{nombre}/EspacioPersonal/{id}/SeriesFinalizadas/{id}")
	@Override
	public void anhadeSeriesFinalizadas(@RequestParam(value="id") Long id,
			@RequestParam(value="series") List<Serie> series) {
		rep.setUsuarioSeriesFinalizadas(id, series);
	}

	@RequestMapping("/Usuario/{nombre}/Factura")
	@Override
	public List<FacturaCobrada> getFacturas(@RequestParam(value="nombre") String nombre) {
		return rep.findFacturasCobradas(nombre);
	}
	
	@RequestMapping("/Usuario/{nombre}/Factura/{id}")
	@Override
	public FacturaCobrada getFactura(@RequestParam(value="nombre") String nombre, 
			@RequestParam(value="fecha") Date fecha) {
		return rep.findFacturaCobrada(nombre, fecha);
	}

	@RequestMapping("/Usuario/{nombre}/Factura/{id}/Capitulo")
	@Override
	public List<CapituloVisto> getCapitulosFactura(@RequestParam(value="nombre") String nombre,
			@RequestParam(value="fecha") Date fecha) {
		return rep.findFacturaCobrada(nombre, fecha).getCapitulosVistos();
	}
	
	@RequestMapping("/Usuario/{nombre}/Factura/{id}/Capitulo/{id}")
	@Override
	public void anhadeCapitulosFactura(@RequestParam(value="id") Long id,
			@RequestParam(value="capitulos") List<CapituloVisto> capitulos) {
		rep.setFacturaCapitulos(id, capitulos);
	}

	@RequestMapping("/Usuario/{nombre}/EspacioPersonal")
	@Override
	public EspacioPersonal getEspacioPersonal(String nombre) {
		return rep.findByNombreUsuario(nombre).getEspacioPersonal();
	}
	
	@RequestMapping("/Usuario/{nombre}/EspacioPersonal/{id}/Capitulo/{id}")
	@Override
	public void anhadeCapitulos(@RequestParam(value="id") Long id,
			@RequestParam(value="capitulos") List<Capitulo> capitulos) {
		rep.setUsuarioCapitulos(id, capitulos);
	}
}
