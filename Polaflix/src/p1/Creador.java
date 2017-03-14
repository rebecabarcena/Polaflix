package p1;
/**
 * Clase que implementa un creador de series 
 */
public class Creador extends Persona
{
	/**
	 * Constructor sin parámetros
	 */
	public Creador() {
		super();
	}

	/**
	 * Constructor con parámetros
	 * @param nombre
	 * @param apellido
	 */
	public Creador(String nombre, String apellido) {
		super(nombre, apellido);
	}
}
