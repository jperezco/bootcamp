package capgemini;

import java.util.*;

public class Adivina_Numero {
	public static void main(String[] args) {
		int aleatorio = (int) (Math.random() * 100);
		Scanner teclado = new Scanner(System.in);
		int numero = 0;
		int intentos = 0;

		do {
			intentos++;
			System.out.println("Introduce el numero");
			numero = teclado.nextInt();
			if (aleatorio < numero) {
				System.out.println("Más bajo");
			}
			if (aleatorio > numero) {
				System.out.println("Más alto");
			}
		} while (numero != aleatorio && intentos <= 10);

		if (intentos <= 10) {
			System.out.println("Número adivinado en " + intentos + " intentos");
		} else if (intentos > 10) {
			System.out.println("Sin intentos. El número era el " + aleatorio);
		}
	}

}
