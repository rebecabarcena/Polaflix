package p1;
/**
 * @(#) Usuario.java
 */

public class Usuario
{
	private EspacioPersonal espacioPersonal;
	
	private FacturaCobrada facturasCobradas;
	
	private String nombreUsuario;
	
	private String cuentaBancaria;
	
	private Boolean cuotaFija = false;
	
	private Capitulo capitulosVistos;

	public Usuario() {
		super();
	}

	public Usuario(EspacioPersonal espacioPersonal, FacturaCobrada facturasCobradas, String nombreUsuario,
			String cuentaBancaria, Boolean cuotaFija, Capitulo capitulosVistos) {
		super();
		this.espacioPersonal = espacioPersonal;
		this.facturasCobradas = facturasCobradas;
		this.nombreUsuario = nombreUsuario;
		this.cuentaBancaria = cuentaBancaria;
		this.cuotaFija = cuotaFija;
		this.capitulosVistos = capitulosVistos;
	}

	public EspacioPersonal getEspacioPersonal() {
		return espacioPersonal;
	}

	public void setEspacioPersonal(EspacioPersonal espacioPersonal) {
		this.espacioPersonal = espacioPersonal;
	}

	public FacturaCobrada getFacturasCobradas() {
		return facturasCobradas;
	}

	public void setFacturasCobradas(FacturaCobrada facturasCobradas) {
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

	public Capitulo getCapitulosVistos() {
		return capitulosVistos;
	}

	public void setCapitulosVistos(Capitulo capitulosVistos) {
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
}
