package capgemini;

import java.util.*;

import capgemini.CartaFrancesa.Palos;
import capgemini.CartaFrancesa.Valores;

public class BarajaFrancesa {
	
	private ArrayList<String> baraja = new ArrayList<String>();
	private ArrayList<String> cartasRepartidas = new ArrayList<String>();
	private int numeroPalos = 4;
	private int numeroValores = 13;
		
	public BarajaFrancesa() {	
		for (int i = 1; i <= numeroPalos; i++) {
			for (int j = 1; j <= numeroValores; j++) {
				CartaFrancesa cartaFrancesa = new CartaFrancesa(Palos.damePaloAsociado(i), 
						Valores.dameValorAsociado(j));
				baraja.add(cartaFrancesa.enseñaCartaFrancesa());
			}
		}
	}
	
	public ArrayList<String> enseñaBarajaFrancesa() {
		return baraja;
	}
	
	public String numeroCartasEnLaBarajaFrancesa() {
		return "En este momento tienes " + baraja.size() + " cartas en la baraja";
	}
	
	public void quitarCartasBarajaFrancesa(int numeroDeCartasAQuitar) throws Exception {
		if (numeroDeCartasAQuitar > baraja.size()) {
			throw new Exception("No puedes quitar tantas cartas porque te quedas sin"
					+ " baraja");
		}
		for (int i = 0; i < numeroDeCartasAQuitar; i++) {
			baraja.remove(0);
		}
	}
	
	public void barajarBarajaFrancesa() {
		Collections.shuffle(baraja);
	}
		
}
