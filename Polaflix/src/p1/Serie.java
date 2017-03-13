package p1;
/**
 * @(#) Serie.java
 */

public class Serie
{
	private Temporada temporadas;
	
	private double precioCapitulo;
	
	private String nombre;
	
	private Integer anhoComienzo;
	
	private String descripcion;
	
	private Creador creador;
	
	private Actor actoresPrincipales;

	public Serie() {
		super();
	}

	public Serie(Temporada temporadas, double precioCapitulo, String nombre, Integer anhoComienzo, String descripcion,
			Creador creador, Actor actoresPrincipales) {
		super();
		this.temporadas = temporadas;
		this.precioCapitulo = precioCapitulo;
		this.nombre = nombre;
		this.anhoComienzo = anhoComienzo;
		this.descripcion = descripcion;
		this.creador = creador;
		this.actoresPrincipales = actoresPrincipales;
	}

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

	public Creador getCreador() {
		return creador;
	}

	public void setCreador(Creador creador) {
		this.creador = creador;
	}

	public Actor getActoresPrincipales() {
		return actoresPrincipales;
	}

	public void setActoresPrincipales(Actor actoresPrincipales) {
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
	
	
}
