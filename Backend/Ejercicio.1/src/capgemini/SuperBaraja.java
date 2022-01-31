package capgemini;

public class SuperBaraja {
	
	private String[] palo = {
			"Picas", "Corazón", "Diamantes", "Trébol"
	};
	
	private String[] valor = {
			"2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jota", "Reina", "Rey", "As"
	};
	
	int num_cartas = palo.length*valor.length;
	String[] baraja = new String[num_cartas];
	
	public void repartir() {
        for (int i = 0; i < valor.length; i++) {
            for (int j = 0; j < palo.length; j++) {
                baraja[palo.length*i + j] = valor[i] + " de " + palo[j];
            }
        }
	}
	
	public void barajar() {
		for (int i = 0; i < num_cartas; i++) {
            int r = i + (int) (Math.random() * (num_cartas-i));
            String temp = baraja[r];
            baraja[r] = baraja[i];
            baraja[i] = temp;
        }
	}
}
