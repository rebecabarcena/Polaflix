package p1;
/**
 * @(#) MarcadorSerie.java
 */

public class MarcadorSerie
{
	private Serie series;
	
	private Capitulo ultimoCapituloVisto;

	public MarcadorSerie() {
		super();
	}

	public MarcadorSerie(Serie series, Capitulo ultimoCapituloVisto) {
		super();
		this.series = series;
		this.ultimoCapituloVisto = ultimoCapituloVisto;
	}

	public Serie getSeries() {
		return series;
	}

	public void setSeries(Serie series) {
		this.series = series;
	}

	public Capitulo getUltimoCapituloVisto() {
		return ultimoCapituloVisto;
	}

	public void setUltimoCapituloVisto(Capitulo ultimoCapituloVisto) {
		this.ultimoCapituloVisto = ultimoCapituloVisto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		result = prime * result + ((ultimoCapituloVisto == null) ? 0 : ultimoCapituloVisto.hashCode());
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
		MarcadorSerie other = (MarcadorSerie) obj;
		if (series == null) {
			if (other.series != null)
				return false;
		} else if (!series.equals(other.series))
			return false;
		if (ultimoCapituloVisto == null) {
			if (other.ultimoCapituloVisto != null)
				return false;
		} else if (!ultimoCapituloVisto.equals(other.ultimoCapituloVisto))
			return false;
		return true;
	}
}
