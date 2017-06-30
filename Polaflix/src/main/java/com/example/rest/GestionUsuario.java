package com.example.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domainModel.Capitulo;
import com.example.domainModel.CapituloVisto;
import com.example.domainModel.EspacioPersonal;
import com.example.domainModel.FacturaCobrada;
import com.example.domainModel.MarcadorSerie;
import com.example.domainModel.Serie;
import com.example.domainModel.Usuario;
import com.example.repositories.SerieRepository;
import com.example.repositories.UsuarioRepository;

@RestController
public class GestionUsuario implements IGestionUsuario {

	@Autowired
	private UsuarioRepository rep;
	@Autowired
	private SerieRepository srep;

	@Autowired
	GestionUsuario(UsuarioRepository rep) {
		this.rep = rep;
	}

	@RequestMapping("/Usuario/{nombre}/EspacioPersonal/{id}/SeriesEmpezadas")
	@Override
	public List<MarcadorSerie> getSeriesEmpezadas(@PathVariable("id") Long id) {
		return rep.findSeriesEmpezadasByEP(id);
	}

	@RequestMapping(value = "/Usuario/{nombre}/EspacioPersonal/{id}/anhadeSerieEmp/{serie}", method = RequestMethod.POST)
	@Override
	@ResponseBody
	public Usuario anhadeSeriesEmpezadas(@PathVariable("nombre") String nombre, @PathVariable("id") Long id,
			@PathVariable("serie") String serie) {
		Usuario user = rep.findByNombreUsuario(nombre);
		Serie s = srep.findByNombre(serie);
		if(!user.getEspacioPersonal().getMarcadoresSeries().contains(s)){
			MarcadorSerie ms = new MarcadorSerie(s,s.getTemporadas().get(1).getCapitulos().get(1));
			rep.save(ms);
			boolean anhade = user.anhadeSerieEmp(ms);
			if(anhade){
				return rep.save(user);
			}
		}
		return null;
	}

	@RequestMapping("/Usuario/{nombre}/EspacioPersonal/{id}/SeriesPendientes")
	@Override
	public List<Serie> getSeriesPendientes(@PathVariable("id") Long id) {
		return rep.findSeriesPendientesByEP(id);
	}

	@RequestMapping(value = "/Usuario/{nombre}/EspacioPersonal/{id}/anhadeSeriePend/{serie}", method = RequestMethod.POST)
	@Override
	@ResponseBody
	public Usuario anhadeSeriesPendientes(@PathVariable("nombre") String nombre, @PathVariable("id") Long id,
			@PathVariable String serie) {
		Usuario user = rep.findByNombreUsuario(nombre);
		Serie s = srep.findByNombre(serie);
		boolean anhade = user.anhadeSeriePen(s);
		if(anhade){
			return rep.save(user);
		}
		return null;
	}

	@RequestMapping("/Usuario/{nombre}/EspacioPersonal/{id}/SeriesFinalizadas")
	@Override
	public List<Serie> getSeriesFinalizadas(@PathVariable("id") Long id) {
		return rep.findSeriesFinalizadasByEP(id);
	}

	@RequestMapping("/Usuario/{nombre}/Factura")
	@Override
	public List<FacturaCobrada> getFacturas(@PathVariable("nombre") String nombre) {
		return rep.findFacturasCobradas(nombre);
	}

	@RequestMapping(value = "/Usuario/{nombre}/verCapitulo/{capitulo}", method = RequestMethod.POST)
	@Override
	@ResponseBody
	public Usuario verCapitulo(@PathVariable("nombre") String nombre,
			@PathVariable("capitulo") String c) {
		Usuario u = rep.findByNombreUsuario(nombre);
		Capitulo cap = srep.findCapituloById(Long.parseLong(c)).get(0);
		// Actualiza el último capítulo visto en la serie, si la está siguiendo
		if(u.getEspacioPersonal().getMarcadorBySerieName(cap.getTemporada().getSerie().getNombre())!=null){
			u.getEspacioPersonal().getMarcadorBySerieName(cap.getTemporada().getSerie().getNombre()).setUltimoCapituloVisto(cap);
		}
		// Añade el capítulo a la lista de capítulos vistos
		u.anhadeCap(cap);
		
		// Añade a la factura
		java.sql.Date date2 = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);
		
		if(u.getFacturasCobradas().get(u.getFacturasCobradas().size()-1).getMes()==
				cal.get(Calendar.MONTH)){
			u.getFacturasCobradas().get(u.getFacturasCobradas().size()-1).
				getCapitulosVistos().add(new CapituloVisto(cap.getTemporada().getSerie().getPrecioCapitulo(),cap,date2));
		} else {
			// Si no existe factura, se crea una nueva
			List<CapituloVisto> caps = new ArrayList<CapituloVisto>();
			caps.add(new CapituloVisto(cap.getTemporada().getSerie().getPrecioCapitulo(),cap,date2));
			FacturaCobrada f = new FacturaCobrada(caps,(java.sql.Date) date2,0);
			u.getFacturasCobradas().add(f);
			rep.save(f);
		}
		return rep.save(u);
	}
	
	@RequestMapping(value = "/Usuario/{nombre}/EspacioPersonal/{id}/nuevoCapituloVisto/{capitulo}", method = RequestMethod.POST)
	@Override
	@ResponseBody
	public Usuario capituloVisto(@PathVariable("nombre") String nombre, @PathVariable("id") Long id,
			@PathVariable("capitulo") String c) {
		Usuario u = rep.findByNombreUsuario(nombre);
		Capitulo cap = srep.findCapituloById(Long.parseLong(c)).get(0);
		// Actualiza el último capítulo visto en la serie, si la está siguiendo
		if(u.getEspacioPersonal().getMarcadorBySerieName(cap.getTemporada().getSerie().getNombre())!=null){
			u.getEspacioPersonal().getMarcadorBySerieName(cap.getTemporada().getSerie().getNombre()).setUltimoCapituloVisto(cap);
		}
		// Añade el capítulo a la lista de capítulos vistos
		boolean anhade = u.capituloVisto(cap);
		if(anhade){
			return rep.save(u);
		}
		return null;
	}

	@RequestMapping("/Usuario/{nombre}/EspacioPersonal")
	@Override
	public EspacioPersonal getEspacioPersonal(@PathVariable("nombre") String nombre) {
		return rep.findByNombreUsuario(nombre).getEspacioPersonal();
	}

	@RequestMapping("/Usuario/{nombre}/EspacioPersonal/{id}/Capitulo")
	@Override
	public List<Capitulo> getCapitulosVistos(@PathVariable("id") Long id) {
		return rep.findCapitulosVistosByEP(id);
	}
}
