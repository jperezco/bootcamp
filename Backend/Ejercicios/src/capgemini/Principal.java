package capgemini;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		JuegoDelNumero e = new JuegoDelNumero();
		e.inicializar();
		System.out.println("El número a acertar es el " + e.aleatorio);
		do{
			e.jugada(teclado.nextInt());
		}while(e.numero != e.aleatorio);
		
	}
}
