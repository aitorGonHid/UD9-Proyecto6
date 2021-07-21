package Objectos;

public class Pelicula {

	// Atributos
	private String titulo;
	private int duracion; // en minutos
	private int edadMinima;
	private String director;
	
	// Getters y setters
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getEdadMinima() {
		return edadMinima;
	}
	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	// Metodo to string
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", duracion=" + duracion + ", edadMinima=" + edadMinima + ", director="
				+ director + "]";
	}
	
	// Constructores
	public Pelicula () {
		this.titulo = "";
		this.edadMinima = 0;
		this.duracion = 0;
		this.director = "";
	}
	public Pelicula(String titulo, int duracion, int edadMinima, String director) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinima = edadMinima;
		this.director = director;
	}
	
	
}
