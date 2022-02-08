package capgemini;

import java.util.ArrayList;

import capgemini.CartaFrancesa.Palos;
import capgemini.CartaFrancesa.Valores;

public class BarajaFrancesa {
	
	ArrayList<CartaFrancesa> baraja = new ArrayList<CartaFrancesa>(); 
	int numeroPalos = 4;
	int numeroValores = 13;
		
	public BarajaFrancesa() {
		
		for (int i = 1; i <= numeroPalos; i++) {
			for (int j = 1; j <= numeroValores; j++) {
				baraja.add(new CartaFrancesa(Palos.damePaloAsociado(i), 
						Valores.dameValorAsociado(j)));
			}
		}
	}
	
}
