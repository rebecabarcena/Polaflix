package com.example.domainModel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Clase que implementa la temporada de una serie
 */
@Entity
public class Temporada implements Comparable<Temporada>, Serializable
{
	@Id 
    @GeneratedValue 
    private Long id;
		
	@OneToMany(cascade = CascadeType.REMOVE)
	// cap�tulos de la temporada
	private List<Capitulo> capitulos;
	
	// nombre de la temporada
	private String nombre;
	
	// n�mero de temporada dentro de la serie
	private Integer numero;
	
	@JsonIgnore
	@OneToOne
	private Serie serie;

	/**
	 * Constructor sin par�metros
	 */
	public Temporada() {
		super();
	}

	/**
	 * Constructor con par�metros
	 * @param capitulos
	 * @param nombre
	 * @param numero
	 */
	public Temporada(List<Capitulo> capitulos, String nombre, Integer numero, Serie serie) {
		super();
		this.capitulos = capitulos;
		this.nombre = nombre;
		this.numero = numero;
		this.serie = serie;
	}
	
	// setters y getters
	
	public Serie getSerie(){
		return serie;
	}
	
	public void setSerie(Serie serie){
		this.serie = serie;
	}

	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capitulos == null) ? 0 : capitulos.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Temporada other = (Temporada) obj;
		if (capitulos == null) {
			if (other.capitulos != null)
				return false;
		} else if (!capitulos.equals(other.capitulos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public int compareTo(Temporada o) {
		if(o.getNombre().equals(this.getNombre()) &&
		   o.getCapitulos().equals(this.getCapitulos()) &&
		   o.getNumero()==this.getNumero()){
			return 0;
		}
		return -1;
	}
}
