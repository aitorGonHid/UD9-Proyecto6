package Objectos;

public class Cine {

	// Atributos
	private Pelicula proyecta; // pelicula que se proyecta en el cine actualmente
	private double precioEntrada; // precio de la entrada del cine
	
	// Constructores
	public Cine() {
		this(new Pelicula(), 10);
	}
	
	public Cine (Pelicula peli, double precio) {
		this.proyecta = peli;
		this.precioEntrada = precio;
	}
	// Getters & setters
	public Pelicula getProyecta() {
		return proyecta;
	}

	public void setProyecta(Pelicula proyecta) {
		this.proyecta = proyecta;
	}

	public double getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(double precioEntrada) {
		this.precioEntrada = precioEntrada;
	}
		
	
}
