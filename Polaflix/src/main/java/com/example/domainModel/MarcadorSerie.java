package com.example.domainModel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Implementa un marcador de una serie, indicando el �ltimo cap�tulo visto
 */
@Entity
public class MarcadorSerie implements Comparable<MarcadorSerie>, Serializable
{
	@Id 
    @GeneratedValue 
    private Long id;
	
	// serie
	@OneToOne
	private Serie serie;
	
	// �ltimo cap�tulo visto
	@OneToOne
	private Capitulo ultimoCapituloVisto;

	/**
	 * Constructor sin par�metros
	 */
	public MarcadorSerie() {
		super();
	}

	/**
	 * Constructor con par�metros
	 * @param series
	 * @param ultimoCapituloVisto
	 */
	public MarcadorSerie(Serie series, Capitulo ultimoCapituloVisto) {
		super();
		this.serie = series;
		this.ultimoCapituloVisto = ultimoCapituloVisto;
	}

	// getters y setters
	
	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Capitulo getUltimoCapituloVisto() {
		return ultimoCapituloVisto;
	}

	public void setUltimoCapituloVisto(Capitulo ultimoCapituloVisto) {
		this.ultimoCapituloVisto = ultimoCapituloVisto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
		result = prime * result + ((ultimoCapituloVisto == null) ? 0 : ultimoCapituloVisto.hashCode());
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
		MarcadorSerie other = (MarcadorSerie) obj;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		if (ultimoCapituloVisto == null) {
			if (other.ultimoCapituloVisto != null)
				return false;
		} else if (!ultimoCapituloVisto.equals(other.ultimoCapituloVisto))
			return false;
		return true;
	}

	@Override
	public int compareTo(MarcadorSerie o) {
		return o.getSerie().compareTo(this.getSerie());
	}
	
}
