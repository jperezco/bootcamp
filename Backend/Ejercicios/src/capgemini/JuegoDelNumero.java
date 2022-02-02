package capgemini;

import java.util.*;

public class JuegoDelNumero {
	public int aleatorio;
	public int intentos;
	public int numero;

	public JuegoDelNumero() {
		aleatorio = 0;
		intentos = 0;
		numero = 0;
	}

	public int inicializar() {
		aleatorio = (int) (Math.random() * 100);
		return aleatorio;
	}

	public void jugada(int prueba) {
		intentos++;
		numero = prueba;
		if (aleatorio < prueba) {
			System.out.println("Más bajo");
		}
		if (aleatorio > prueba) {
			System.out.println("Más alto");
		}
		if (aleatorio == prueba) {
			System.out.println("Has acertado, el número era el " + prueba);
		}

	}
}
