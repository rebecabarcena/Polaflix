package com.example.domainModel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Implementa una serie gold.
 */
@Entity
public class Gold extends Serie implements Serializable
{
	@Id
	@GeneratedValue 
    private Long id;
	
	
	private double precioCapitulo = 1.5;

	/**
	 * Construcor sin par�metros
	 */
	public Gold() {
		super();
	}
	
	/**
	 * Constructor con par�metros
	 * @param temporadas
	 * @param precioCapitulo
	 * @param nombre
	 * @param anhoComienzo
	 * @param descripcion
	 * @param creador
	 * @param actoresPrincipales
	 */
	public Gold(List<Temporada> temporadas, double precioCapitulo, String nombre, Integer anhoComienzo, String descripcion,
			List<Creador> creador, List<Actor> actoresPrincipales) {
		super(temporadas, precioCapitulo, nombre, anhoComienzo, descripcion, creador, actoresPrincipales);
	}

	public Gold(double precioCapitulo) {
		super();
		this.precioCapitulo = precioCapitulo;
	}
	
	// getters y setters
	@JsonProperty("tipo")
	public String getNombreTemporada(){
		return "Gold";
	}
	
	public double getPrecioCapitulo() {
		return precioCapitulo;
	}

	public void setPrecioCapitulo(double precioCapitulo) {
		this.precioCapitulo = precioCapitulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(precioCapitulo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gold other = (Gold) obj;
		if (Double.doubleToLongBits(precioCapitulo) != Double.doubleToLongBits(other.precioCapitulo))
			return false;
		return true;
	}
	
	
}
