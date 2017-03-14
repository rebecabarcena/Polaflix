package p1;
/**
 * Clase que implementa un capítulo
 */
public class Capitulo implements Comparable<Capitulo>
{
	// nombre
	private String nombre;
	
	// número dentro de la temporada
	private Integer numero;
	
	// enlace al capítulo
	private String enlace;
	
	// temporada a la que pertenece
	private Temporada temporada;
	
	/**
	 * Constructor vacío
	 */
	public Capitulo() {
		super();
	}

	/**
	 * Constructor con parámetros
	 * @param nombre
	 * @param numero
	 * @param enlace
	 * @param temporada
	 */
	public Capitulo(String nombre, Integer numero, String enlace, Temporada temporada) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.enlace = enlace;
		this.temporada = temporada;
	}

	// Setters y getters de los atributos
	
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

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	/**
	 * Método hashcode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enlace == null) ? 0 : enlace.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((temporada == null) ? 0 : temporada.hashCode());
		return result;
	}

	/**
	 * Método equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Capitulo other = (Capitulo) obj;
		if (enlace == null) {
			if (other.enlace != null)
				return false;
		} else if (!enlace.equals(other.enlace))
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
		if (temporada == null) {
			if (other.temporada != null)
				return false;
		} else if (!temporada.equals(other.temporada))
			return false;
		return true;
	}

	/**
	 * Método compareTo
	 * @param arg0
	 * @return 0 si son iguales, 1 si el capitulo pasado
	 * es anterior a este y -1 en cualquier otro caso
	 */
	@Override
	public int compareTo(Capitulo o) {
		if(o.getNombre().equals(this.getNombre()) &&
		   o.getTemporada().equals(this.getTemporada())){
			if(o.getNumero()==this.getNumero()){
				return 0;
			} else if(o.getNumero()<this.getNumero()){
				return 1;
			}
		}
		return -1;
	}
}
