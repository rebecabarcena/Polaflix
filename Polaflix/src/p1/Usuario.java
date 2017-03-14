package p1;

import java.util.List;

/**
 * Clase que implementa un usuario de la plataforma Poliflix
 */
public class Usuario implements Comparable<Usuario>
{
	// espacio personal del usuario
	private EspacioPersonal espacioPersonal;
	
	// listado de facturas cobradas
	private List<FacturaCobrada> facturasCobradas;
	
	// nombre de usuario
	private String nombreUsuario;
	
	// cuenta bancaria asociada
	private String cuentaBancaria;
	
	// booleano que indica si tiene una cuota fija (siempre paga
	// lo mismo sin depender de qué ve) o no (paga en función de
	// lo que ve)
	private Boolean cuotaFija = false;
	
	// listado de capítulos vistos
	private List<Capitulo> capitulosVistos;

	/**
	 * Constructor sin parámetros
	 */
	public Usuario() {
		super();
	}

	/**
	 * Getters y setters
	 * @param espacioPersonal
	 * @param facturasCobradas
	 * @param nombreUsuario
	 * @param cuentaBancaria
	 * @param cuotaFija
	 * @param capitulosVistos
	 */
	public Usuario(EspacioPersonal espacioPersonal, List<FacturaCobrada> facturasCobradas, String nombreUsuario,
			String cuentaBancaria, Boolean cuotaFija, List<Capitulo> capitulosVistos) {
		super();
		this.espacioPersonal = espacioPersonal;
		this.facturasCobradas = facturasCobradas;
		this.nombreUsuario = nombreUsuario;
		this.cuentaBancaria = cuentaBancaria;
		this.cuotaFija = cuotaFija;
		this.capitulosVistos = capitulosVistos;
	}

	// getters y setters
	
	public EspacioPersonal getEspacioPersonal() {
		return espacioPersonal;
	}

	public void setEspacioPersonal(EspacioPersonal espacioPersonal) {
		this.espacioPersonal = espacioPersonal;
	}

	public List<FacturaCobrada> getFacturasCobradas() {
		return facturasCobradas;
	}

	public void setFacturasCobradas(List<FacturaCobrada> facturasCobradas) {
		this.facturasCobradas = facturasCobradas;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public Boolean getCuotaFija() {
		return cuotaFija;
	}

	public void setCuotaFija(Boolean cuotaFija) {
		this.cuotaFija = cuotaFija;
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
		result = prime * result + ((cuentaBancaria == null) ? 0 : cuentaBancaria.hashCode());
		result = prime * result + ((cuotaFija == null) ? 0 : cuotaFija.hashCode());
		result = prime * result + ((espacioPersonal == null) ? 0 : espacioPersonal.hashCode());
		result = prime * result + ((facturasCobradas == null) ? 0 : facturasCobradas.hashCode());
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (capitulosVistos == null) {
			if (other.capitulosVistos != null)
				return false;
		} else if (!capitulosVistos.equals(other.capitulosVistos))
			return false;
		if (cuentaBancaria == null) {
			if (other.cuentaBancaria != null)
				return false;
		} else if (!cuentaBancaria.equals(other.cuentaBancaria))
			return false;
		if (cuotaFija == null) {
			if (other.cuotaFija != null)
				return false;
		} else if (!cuotaFija.equals(other.cuotaFija))
			return false;
		if (espacioPersonal == null) {
			if (other.espacioPersonal != null)
				return false;
		} else if (!espacioPersonal.equals(other.espacioPersonal))
			return false;
		if (facturasCobradas == null) {
			if (other.facturasCobradas != null)
				return false;
		} else if (!facturasCobradas.equals(other.facturasCobradas))
			return false;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		return true;
	}

	@Override
	public int compareTo(Usuario o) {
		return o.getNombreUsuario().compareTo(this.getNombreUsuario());
	}
}
