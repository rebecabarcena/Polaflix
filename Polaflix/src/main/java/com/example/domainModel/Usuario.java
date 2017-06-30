package com.example.domainModel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Clase que implementa un usuario de la plataforma Poliflix
 */
@Entity
public class Usuario implements Comparable<Usuario>, Serializable
{
	@OneToOne(cascade = CascadeType.REMOVE)
	// espacio personal del usuario
	private EspacioPersonal espacioPersonal;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	// listado de facturas cobradas
	private List<FacturaCobrada> facturasCobradas;
	
	@Id
	// nombre de usuario
	private String nombreUsuario;
	
	// cuenta bancaria asociada
	private String cuentaBancaria;
	
	// booleano que indica si tiene una cuota fija (siempre paga
	// lo mismo sin depender de qu� ve) o no (paga en funci�n de
	// lo que ve)
	private Boolean cuotaFija = false;
	
	/**
	 * Constructor sin par�metros
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
			String cuentaBancaria, Boolean cuotaFija) {
		super();
		this.espacioPersonal = espacioPersonal;
		this.facturasCobradas = facturasCobradas;
		this.nombreUsuario = nombreUsuario;
		this.cuentaBancaria = cuentaBancaria;
		this.cuotaFija = cuotaFija;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
	
	public boolean anhadeSeriePen(Serie s){
		if(espacioPersonal.getSeriesPendientes().contains(s)){
			return false;
		}
		espacioPersonal.anhadeSeriePendiente(s);
		return true;
	}
	
	public boolean anhadeSerieEmp(MarcadorSerie ms){
		if(espacioPersonal.getMarcadoresSeries().contains(ms)){
			return false;
		}
		espacioPersonal.anhadeMarcadorSerie(ms);
		return true;
	}
	
	public boolean capituloVisto(Capitulo c){
		if(espacioPersonal.getMarcadorBySerieName(c.getTemporada().getSerie().getNombre())==null){
			return false;
		}
		espacioPersonal.anhadeCapitulo(c);
		return true;
	}
	
	public boolean anhadeCap(Capitulo c){
		if(!espacioPersonal.getCapitulosVistos().contains(c)){
			return espacioPersonal.anhadeCapitulo(c);
		}
		return false;
	}
}
