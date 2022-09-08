import java.math.BigInteger;

public class Pelicula {
	
	private String nombre;
	private BigInteger recaudacion;
	
	public Pelicula(String nombre, BigInteger recaudacion) {
		this.nombre = nombre;
		this.recaudacion = recaudacion;
	}

	@Override
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", recaudacion=" + recaudacion + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigInteger getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(BigInteger recaudacion) {
		this.recaudacion = recaudacion;
	}
	
}
