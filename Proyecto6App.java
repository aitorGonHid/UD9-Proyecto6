import java.util.Random;

import javax.swing.JOptionPane;

import Objectos.Cine;
import Objectos.Espectador;
import Objectos.Pelicula;

public class Proyecto6App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Objetos creados
		Pelicula peli = new Pelicula("HOLA", 80, 18, "Yo");
		Cine cine1 = new Cine (peli, 8);
		
		final int FILA = 8, COL = 9;
		
		// Sala de cine
		char[][] sala = new char[FILA][COL];
		// Otras variables
		int fila, col, total = FILA * COL; // total de asientos
		boolean generar;
		String pregunta;
		
		// Llenamos la matriz con un caracter en concreto '~'
		llenarMatriz(sala);
		
		// Bucle para ir generando espectadores
		do {
			generar = false; // Le indicamos que es false para la condicion de salida
			// Generamos un espectador con edad y dinero random (el nombre sera siempre el mismo pero ahora mismo da un poco igual)
			Espectador esp = new Espectador ("Pedro", edadRandom(), dineroRandom());
			
			//Si es apto para entrar al cine (por su dinero y edad)
			if (esp.compraEntrada(cine1) && (esp.aptoEdad(peli))) {
				boolean puesto = false; // Condicion de parada para el bucle (Puesto = true --> usuario puesto)
				// Para si tiene edad y dinero se ponga si hay espacio disponible
				while (!puesto) {
					fila = asientoRandom(FILA); // Fila random en funcion del numero de filas
					col = asientoRandom(COL); // Columna random en funcion del numero de columnas
					if (sala[fila][col] == '~') { // Comparamos lo que hay en esa posicion de la matriz ('~' esta vacio)
						sala[fila][col] = 'X'; 
						System.out.println("Asiento comprado"); // Mostramos que se ha comprado
						puesto = true; // Condicion de salida del bucle
						total--; // Restamos un asiento al total
					}
				}
			}
			// Si no es apto por dinero o edad
			else {
				// Mostramos edad y dinero del usuario y edad minima y precio del cine
				System.out.println("No puedes entrar:");
				System.out.println("Tu edad " + esp.getEdad() + " --> Edad minima " + peli.getEdadMinima());
				System.out.println("Tu dinero " + esp.getDinero() + " --> Precio del cine "+ cine1.getPrecioEntrada());
			}
			
			// Preguntamos si quiere generar mas usuarios
			pregunta = JOptionPane.showInputDialog("Generar mas espectadores? (si/no)").toLowerCase(); // Lo pasamos a lowerCase
			
			// Si ha dicho que si...
			if (pregunta.equals("si")) {
				generar = true; // En caso de que si se generen mas el boolean a true
			}
			
		} while (generar && total != 0); // Saldra si no se quiere generar mas o total llege a 0
		
		// Para terminar mostramos el estado del cine
		System.out.println("El cine ha quedado asi:");
		mostrarCine(sala);
		
	}
	
	// Para ver la sala del cine al final
	public static void mostrarCine(char[][] sala) {
		final int CARACTER = 65; // Este es el valor de el caracter 'A' en ASCII
		int i, j, caracter, max = sala.length;
		for (i = 0; i < sala.length; i++, max--) {
			caracter = CARACTER; // Esto es para las letra
			for (j = 0; j < sala[i].length; j++, caracter++) {
				System.out.print(max + "" + (char)caracter + "" + sala[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// Para los datos random del espectador
	public static int edadRandom () {
		Random rnd = new Random();
		return (int) (rnd.nextDouble()* 80 + 1);	// Edad entre 1 y 80 años	
	}

	public static int dineroRandom () {
		Random rnd = new Random();
		return (int) (rnd.nextDouble()*50 + 1);		// Dinero random entre 1 y 50 euros
	}
	
	// Para generar una fila y columna random (depende del maximo)
	public static int asientoRandom (int max) {
		Random rnd = new Random();
		return (int)(rnd.nextDouble() * max);
	}
	
	// Para iniciar la matriz a un caracter
	public static void llenarMatriz (char[][] sala) {
		int i, j;
		for (i = 0; i < sala.length; i++) {
			for (j = 0; j < sala[i].length; j++) {
				sala[i][j] = '~';
			}
		}
	}
}
