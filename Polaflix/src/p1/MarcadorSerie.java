package p1;
/**
 * Implementa un marcador de una serie, indicando el último capítulo visto
 */
public class MarcadorSerie implements Comparable<MarcadorSerie>
{
	// serie
	private Serie serie;
	
	// último capítulo visto
	private Capitulo ultimoCapituloVisto;

	/**
	 * Constructor sin parámetros
	 */
	public MarcadorSerie() {
		super();
	}

	/**
	 * Constructor con parámetros
	 * @param series
	 * @param ultimoCapituloVisto
	 */
	public MarcadorSerie(Serie series, Capitulo ultimoCapituloVisto) {
		super();
		this.serie = series;
		this.ultimoCapituloVisto = ultimoCapituloVisto;
	}

	// getters y setters
	
	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
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
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
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
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		if (ultimoCapituloVisto == null) {
			if (other.ultimoCapituloVisto != null)
				return false;
		} else if (!ultimoCapituloVisto.equals(other.ultimoCapituloVisto))
			return false;
		return true;
	}

	@Override
	public int compareTo(MarcadorSerie o) {
		return o.getSerie().compareTo(this.getSerie());
	}
}
