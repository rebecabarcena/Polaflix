package p1;

import java.util.List;

/**
 * Clase que implementa una serie
 */
public class Serie implements Comparable<Serie>
{
	// temporadas que tiene la serie
	private Temporada temporadas;
	
	// precio que tiene por ver cada capítulo
	private double precioCapitulo;
	
	// nombre de la serie
	private String nombre;
	
	// año en el que comenzó
	private Integer anhoComienzo;
	
	// descripción de la serie
	private String descripcion;
	
	// creadores de la serie
	private List<Creador> creador;
	
	// actores principales
	private List<Actor> actoresPrincipales;

	/**
	 * Constructor sin parámetros
	 */
	public Serie() {
		super();
	}

	/**
	 * Constructor con parámetros
	 * @param temporadas
	 * @param precioCapitulo
	 * @param nombre
	 * @param anhoComienzo
	 * @param descripcion
	 * @param creador
	 * @param actoresPrincipales
	 */
	public Serie(Temporada temporadas, double precioCapitulo, String nombre, Integer anhoComienzo, String descripcion,
			List<Creador> creador, List<Actor> actoresPrincipales) {
		super();
		this.temporadas = temporadas;
		this.precioCapitulo = precioCapitulo;
		this.nombre = nombre;
		this.anhoComienzo = anhoComienzo;
		this.descripcion = descripcion;
		this.creador = creador;
		this.actoresPrincipales = actoresPrincipales;
	}

	// getters y setters
	
	public Temporada getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(Temporada temporadas) {
		this.temporadas = temporadas;
	}

	public double getPrecioCapitulo() {
		return precioCapitulo;
	}

	public void setPrecioCapitulo(double precioCapitulo) {
		this.precioCapitulo = precioCapitulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAnhoComienzo() {
		return anhoComienzo;
	}

	public void setAnhoComienzo(Integer anhoComienzo) {
		this.anhoComienzo = anhoComienzo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Creador> getCreador() {
		return creador;
	}

	public void setCreador(List<Creador> creador) {
		this.creador = creador;
	}

	public List<Actor> getActoresPrincipales() {
		return actoresPrincipales;
	}

	public void setActoresPrincipales(List<Actor> actoresPrincipales) {
		this.actoresPrincipales = actoresPrincipales;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actoresPrincipales == null) ? 0 : actoresPrincipales.hashCode());
		result = prime * result + ((anhoComienzo == null) ? 0 : anhoComienzo.hashCode());
		result = prime * result + ((creador == null) ? 0 : creador.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precioCapitulo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((temporadas == null) ? 0 : temporadas.hashCode());
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
		Serie other = (Serie) obj;
		if (actoresPrincipales == null) {
			if (other.actoresPrincipales != null)
				return false;
		} else if (!actoresPrincipales.equals(other.actoresPrincipales))
			return false;
		if (anhoComienzo == null) {
			if (other.anhoComienzo != null)
				return false;
		} else if (!anhoComienzo.equals(other.anhoComienzo))
			return false;
		if (creador == null) {
			if (other.creador != null)
				return false;
		} else if (!creador.equals(other.creador))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(precioCapitulo) != Double.doubleToLongBits(other.precioCapitulo))
			return false;
		if (temporadas == null) {
			if (other.temporadas != null)
				return false;
		} else if (!temporadas.equals(other.temporadas))
			return false;
		return true;
	}

	@Override
	public int compareTo(Serie o) {
		if(o.nombre.equals(this.getNombre()) && o.getCreador().equals(this.getCreador())){
			return 0;
		}
		return -1;
	}
	
	
}
