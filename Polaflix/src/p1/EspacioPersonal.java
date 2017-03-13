package p1;
/**
 * @(#) EspacioPersonal.java
 */

public class EspacioPersonal
{
	private Serie seriesPendientes;
	
	private Serie seriesFinalizadas;
	
	private MarcadorSerie marcadoresSeries;

	public EspacioPersonal() {
		super();
	}

	public EspacioPersonal(Serie seriesPendientes, Serie seriesFinalizadas, MarcadorSerie marcadoresSeries) {
		super();
		this.seriesPendientes = seriesPendientes;
		this.seriesFinalizadas = seriesFinalizadas;
		this.marcadoresSeries = marcadoresSeries;
	}

	public Serie getSeriesPendientes() {
		return seriesPendientes;
	}

	public void setSeriesPendientes(Serie seriesPendientes) {
		this.seriesPendientes = seriesPendientes;
	}

	public Serie getSeriesFinalizadas() {
		return seriesFinalizadas;
	}

	public void setSeriesFinalizadas(Serie seriesFinalizadas) {
		this.seriesFinalizadas = seriesFinalizadas;
	}

	public MarcadorSerie getMarcadoresSeries() {
		return marcadoresSeries;
	}

	public void setMarcadoresSeries(MarcadorSerie marcadoresSeries) {
		this.marcadoresSeries = marcadoresSeries;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marcadoresSeries == null) ? 0 : marcadoresSeries.hashCode());
		result = prime * result + ((seriesFinalizadas == null) ? 0 : seriesFinalizadas.hashCode());
		result = prime * result + ((seriesPendientes == null) ? 0 : seriesPendientes.hashCode());
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
		EspacioPersonal other = (EspacioPersonal) obj;
		if (marcadoresSeries == null) {
			if (other.marcadoresSeries != null)
				return false;
		} else if (!marcadoresSeries.equals(other.marcadoresSeries))
			return false;
		if (seriesFinalizadas == null) {
			if (other.seriesFinalizadas != null)
				return false;
		} else if (!seriesFinalizadas.equals(other.seriesFinalizadas))
			return false;
		if (seriesPendientes == null) {
			if (other.seriesPendientes != null)
				return false;
		} else if (!seriesPendientes.equals(other.seriesPendientes))
			return false;
		return true;
	}
	
	
}
