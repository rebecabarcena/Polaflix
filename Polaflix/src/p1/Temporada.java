package p1;
/**
 * @(#) Temporada.java
 */

public class Temporada
{
	private Capitulo capitulos;
	
	private String nombre;
	
	private Integer numero;

	public Temporada() {
		super();
	}

	public Temporada(Capitulo capitulos, String nombre, Integer numero) {
		super();
		this.capitulos = capitulos;
		this.nombre = nombre;
		this.numero = numero;
	}

	public Capitulo getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(Capitulo capitulos) {
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
}
