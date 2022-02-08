package capgemini;

import capgemini.CartaFrancesa.Palos;
import capgemini.CartaFrancesa.Valores;

public class Pruebas {

	public static void main(String[] args) {
		Palos palo = Palos.DIAMANTES;
		System.out.println(palo.dameNumeroAsociado());
		System.out.println(Palos.damePaloAsociado(1));
		Valores valor = Valores.JOTA;
		System.out.println(valor.dameNumeroAsociado());

	}

}
