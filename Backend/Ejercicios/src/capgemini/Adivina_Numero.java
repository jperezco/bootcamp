package capgemini;

import java.util.*;

public class Adivina_Numero {
	
	public static void main(String[] args) {
		int numeroAleatorioBuscado = (int) (Math.random() * 100);
		Scanner teclado = new Scanner(System.in);
		int numeroEscogido = 0;
		int intentos = 0;

		do {
			intentos++;
			System.out.println("Introduce el numero");
			numeroEscogido = teclado.nextInt();
			if (numeroAleatorioBuscado < numeroEscogido) {
				System.out.println("Más bajo");
			}
			if (numeroAleatorioBuscado > numeroEscogido) {
				System.out.println("Más alto");
			}
		} while (numeroEscogido != numeroAleatorioBuscado && intentos <= 10);

		if (intentos <= 10) {
			System.out.println("Número adivinado en " + intentos + " intentos");
		} else if (intentos > 10) {
			System.out.println("Sin intentos. El número era el " + numeroAleatorioBuscado);
		}
	}

}
