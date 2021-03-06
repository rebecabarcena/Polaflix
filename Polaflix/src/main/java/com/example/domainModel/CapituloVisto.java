package com.example.domainModel;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase que implementa un cap�tulo visto
 */
@Entity
public class CapituloVisto implements Comparable<CapituloVisto>, Serializable
{
	@Id 
    @GeneratedValue 
    private Long id;
	
	// precio
	private double precio;
	
	@OneToOne
	// capitulo
	private Capitulo capitulo;
	
	// fecha en la que se vio
	private Date fecha;

	/**
	 * Constructor vac�o
	 */
	public CapituloVisto() {
		super();
	}

	/**
	 * Constructor con par�metros.
	 * @param precio
	 * @param capitulo
	 * @param fecha
	 */
	public CapituloVisto(double precio, Capitulo capitulo, Date fecha) {
		super();
		this.precio = precio;
		this.capitulo = capitulo;
		this.fecha = fecha;
	}

	// getters y setters

	@JsonProperty("temporada")
	public String getNombreTemporada(){
		if(capitulo.getTemporada()==null){
			return "";
		}
		return capitulo.getTemporada().getNumero().toString();
	}
	
	@JsonProperty("serie")
	public String getNombreSerie(){
		return capitulo.getTemporada().getSerie().getNombre();
	}
		
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Capitulo getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capitulo == null) ? 0 : capitulo.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		CapituloVisto other = (CapituloVisto) obj;
		if (capitulo == null) {
			if (other.capitulo != null)
				return false;
		} else if (!capitulo.equals(other.capitulo))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
			return false;
		return true;
	}

	@Override
	public int compareTo(CapituloVisto o) {
		return o.getCapitulo().compareTo(this.getCapitulo());
	}	
}
