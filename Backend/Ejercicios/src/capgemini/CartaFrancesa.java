package capgemini;

public class CartaFrancesa {
	
	public enum Palos{
		TRÉBOLES(1), DIAMANTES(2), CORAZONES(3), PICAS(4);
		
		private int numeroAsociado;
		
		private Palos(int numeroAsociado) {
			this.numeroAsociado = numeroAsociado;
		}
		
		public int dameNumeroAsociado() {
			return numeroAsociado;
		}
		
		public static Palos damePaloAsociado(int numeroAsociado) {
			switch(numeroAsociado) {
			case 1: return Palos.TRÉBOLES;
			case 2: return Palos.DIAMANTES;
			case 3: return Palos.CORAZONES;
			case 4: return Palos.PICAS;
			default:
				throw new IllegalArgumentException("Valor " + numeroAsociado + 
						" no esperado");
			}
		}
	}
	
	public enum Valores{
		AS(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8), NUEVE(9),
		DIEZ(10), JOTA(11), REINA(12), REY(13);
		
		private int numeroAsociado;
		
		private Valores(int numeroAsociado) {
			this.numeroAsociado = numeroAsociado;
		}
		
		public int dameNumeroAsociado() {
			return numeroAsociado;
		}
		
		public static Valores dameValorAsociado(int numeroAsociado) {
			switch(numeroAsociado) {
			case 1: return Valores.AS;
			case 2: return Valores.DOS;
			case 3: return Valores.TRES;
			case 4: return Valores.CUATRO;
			case 5: return Valores.CINCO;
			case 6: return Valores.SEIS;
			case 7: return Valores.SIETE;
			case 8: return Valores.OCHO;
			case 9: return Valores.NUEVE;
			case 10: return Valores.DIEZ;
			case 11: return Valores.JOTA;
			case 12: return Valores.REINA;
			case 13: return Valores.REY;
			default:
				throw new IllegalArgumentException("Valor " + numeroAsociado + 
						" no esperado");
			}
		}
	}
	
	
	Palos palo;
	Valores valor;
	
	public CartaFrancesa (Palos palo, Valores valor) {
		this.palo = palo;
		this.valor = valor;
	}
}
