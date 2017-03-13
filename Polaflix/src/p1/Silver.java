package p1;
/**
 * @(#) Silver.java
 */

public class Silver extends Serie
{
	private double precioCapitulo = 0.75;

	public Silver() {
		super();
	}

	public Silver(Temporada temporadas, double precioCapitulo, String nombre, Integer anhoComienzo, String descripcion,
			Creador creador, Actor actoresPrincipales) {
		super(temporadas, precioCapitulo, nombre, anhoComienzo, descripcion, creador, actoresPrincipales);
	}

	public Silver(double precioCapitulo) {
		super();
		this.precioCapitulo = precioCapitulo;
	}

	public double getPrecioCapitulo() {
		return precioCapitulo;
	}

	public void setPrecioCapitulo(double precioCapitulo) {
		this.precioCapitulo = precioCapitulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(precioCapitulo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Silver other = (Silver) obj;
		if (Double.doubleToLongBits(precioCapitulo) != Double.doubleToLongBits(other.precioCapitulo))
			return false;
		return true;
	}
	
	
}
