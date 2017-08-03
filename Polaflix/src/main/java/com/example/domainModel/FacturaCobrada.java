package com.example.domainModel;
import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * Implementa una factura
 */
@Entity
public class FacturaCobrada implements Comparable<FacturaCobrada>, Serializable
{
	@Id
	@GeneratedValue 
    private Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	// capitulos vistos incluidos en la factura 
	private List<CapituloVisto> capitulosVistos;
	
	// fecha de la factura
	private Date fecha;
	
	@Transient
	// precio total
	private double total;
	
	private String nombreUsuario;
	
	/**
	 * Constructor sin par�metros
	 */
	public FacturaCobrada() {
		super();
	}

	/**
	 * Constructor con par�metros
	 * @param capitulosVistos
	 * @param fecha
	 * @param total
	 */
	public FacturaCobrada(List<CapituloVisto> capitulosVistos, Date fecha, double total, String nombreUsuario) {
		super();
		this.capitulosVistos = capitulosVistos;
		this.fecha = fecha;
		this.total = total;
		this.nombreUsuario = nombreUsuario;
	}

	public List<CapituloVisto> getCapitulosVistos() {
		return capitulosVistos;
	}

	public void setCapitulosVistos(List<CapituloVisto> capitulosVistos) {
		this.capitulosVistos = capitulosVistos;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capitulosVistos == null) ? 0 : capitulosVistos.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		FacturaCobrada other = (FacturaCobrada) obj;
		if (capitulosVistos == null) {
			if (other.capitulosVistos != null)
				return false;
		} else if (!capitulosVistos.equals(other.capitulosVistos))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

	/**
	 * Retorna 0 si son iguales, 1 si la factura pasada
	 * es anterior a esta y -1 en cualquier otro caso
	 */
	@Override
	public int compareTo(FacturaCobrada o) {
		if(o.getFecha().equals(this.fecha) && o.getCapitulosVistos().equals(this.capitulosVistos)){
			return 0;
		} else if (o.getFecha().before(this.fecha)){
			return 1;
		} else {
			return -1;
		}
	}
	
	public int getMes(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		return cal.get(Calendar.MONTH);
	}
	
	public void anhaceCap(CapituloVisto c){
		capitulosVistos.add(c);
	}
}
