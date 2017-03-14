package p1;
/**
 * Clase que implementa una persona
 */
public class Persona implements Comparable<Persona>
{
	// nombre
	private String nombre;
	
	// primer apellido
	private String apellido;
	
	/**
	 * Constructor sin parámetros
	 */
	public Persona() {
		super();
	}

	/**
	 * Constructor con parámetros
	 * @param nombre
	 * @param apellido
	 */
	public Persona(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	// getters y setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public int compareTo(Persona o) {
		if(o.getNombre().equals(this.getNombre()) && o.getApellido().equals(this.getApellido())){
			return 0;
		}
		return -1;
	}
}
