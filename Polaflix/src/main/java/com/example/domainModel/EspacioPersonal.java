package com.example.domainModel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Implementa el espacio personal de un usuario
 */
@Entity
public class EspacioPersonal implements Comparable<EspacioPersonal>, Serializable
{
	@Id
	@GeneratedValue 
    private Long id;
	
	@OneToMany
	// lista de series pendientes
	private List<Serie> seriesPendientes;
	
	@OneToMany
	// lista de series finalizadas
	private List<Serie> seriesFinalizadas;
	
	@OneToMany
	// se usa para marcar el �ltimo cap�tulo visto de cada serie
	private List<MarcadorSerie> marcadoresSeries;

	@OneToMany
	// listado de cap�tulos vistos
	private List<Capitulo> capitulosVistos;

	/**
	 * Constructor sin par�metros
	 */
	public EspacioPersonal() {
		super();
	}

	/**
	 * Constructor con par�metros
	 * @param seriesPendientes
	 * @param seriesFinalizadas
	 * @param marcadoresSeries
	 */
	public EspacioPersonal(List<Serie> seriesPendientes, List<Serie> seriesFinalizadas, List<MarcadorSerie> marcadoresSeries,
			List<Capitulo> capitulosVistos) {
		super();
		this.seriesPendientes = seriesPendientes;
		this.seriesFinalizadas = seriesFinalizadas;
		this.marcadoresSeries = marcadoresSeries;
		this.capitulosVistos = capitulosVistos;
	}
	
	// getters y setters

	public List<Serie> getSeriesPendientes() {
		return seriesPendientes;
	}

	public void setSeriesPendientes(List<Serie> seriesPendientes) {
		this.seriesPendientes = seriesPendientes;
	}

	public List<Serie> getSeriesFinalizadas() {
		return seriesFinalizadas;
	}

	public void setSeriesFinalizadas(List<Serie> seriesFinalizadas) {
		this.seriesFinalizadas = seriesFinalizadas;
	}

	public List<MarcadorSerie> getMarcadoresSeries() {
		return marcadoresSeries;
	}

	public void setMarcadoresSeries(List<MarcadorSerie> marcadoresSeries) {
		this.marcadoresSeries = marcadoresSeries;
	}

	public List<Capitulo> getCapitulosVistos() {
		return capitulosVistos;
	}

	public void setCapitulosVistos(List<Capitulo> capitulosVistos) {
		this.capitulosVistos = capitulosVistos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capitulosVistos == null) ? 0 : capitulosVistos.hashCode());
		result = prime * result + ((marcadoresSeries == null) ? 0 : marcadoresSeries.hashCode());
		result = prime * result + ((seriesFinalizadas == null) ? 0 : seriesFinalizadas.hashCode());
		result = prime * result + ((seriesPendientes == null) ? 0 : seriesPendientes.hashCode());
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
		EspacioPersonal other = (EspacioPersonal) obj;
		if (capitulosVistos == null) {
			if (other.capitulosVistos != null)
				return false;
		} else if (!capitulosVistos.equals(other.capitulosVistos))
			return false;
		if (marcadoresSeries == null) {
			if (other.marcadoresSeries != null)
				return false;
		} else if (!marcadoresSeries.equals(other.marcadoresSeries))
			return false;
		if (seriesFinalizadas == null) {
			if (other.seriesFinalizadas != null)
				return false;
		} else if (!seriesFinalizadas.equals(other.seriesFinalizadas))
			return false;
		if (seriesPendientes == null) {
			if (other.seriesPendientes != null)
				return false;
		} else if (!seriesPendientes.equals(other.seriesPendientes))
			return false;
		return true;
	}

	/**
	 * Retorna un 0 si son iguales y un -1 sino.
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(EspacioPersonal o) {
		if(this.getMarcadoresSeries().equals(o.getMarcadoresSeries()) &&
		   this.getSeriesFinalizadas().equals(o.getSeriesFinalizadas()) &&
		   this.getSeriesPendientes().equals(o.getSeriesPendientes())){
			return 0;
		}
		return -1;
	}
	
	
}
