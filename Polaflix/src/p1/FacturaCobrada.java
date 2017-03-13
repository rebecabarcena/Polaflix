package p1;
import java.sql.Date;

/**
 * @(#) FacturaCobrada.java
 */

public class FacturaCobrada
{
	private CapituloVisto capitulosVistos;
	
	private Date fecha;
	
	private double total;
	
	public FacturaCobrada() {
		super();
	}

	public FacturaCobrada(CapituloVisto capitulosVistos, Date fecha, double total) {
		super();
		this.capitulosVistos = capitulosVistos;
		this.fecha = fecha;
		this.total = total;
	}

	public CapituloVisto getCapitulosVistos() {
		return capitulosVistos;
	}

	public void setCapitulosVistos(CapituloVisto capitulosVistos) {
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
}
