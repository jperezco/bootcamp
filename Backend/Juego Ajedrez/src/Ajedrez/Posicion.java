package Ajedrez;

public class Posicion {
	
	private int laFila;
	private int laColumna;
	
	public Posicion(int laFila, int laColumna) throws Exception{
		if (laFila < 1 || laFila > 8 || laColumna < 1 || laColumna > 8) {
			throw new Exception("Te has colocado fuera del tablero");
		}
		
		this.laFila = laFila;
		this.laColumna = laColumna;	
	}
	
	public Posicion(char laFila, char laColumna) throws Exception{
		this.laFila = Character.getNumericValue(laFila);
		if (this.laFila < 1 || this.laFila > 8) {
			throw new Exception("Te has colocado fuera del tablero");
		}
		switch (laColumna) {
			case 'A': case 'a': this.laColumna = 1; break;
			case 'B': case 'b': this.laColumna = 2; break;
			case 'C': case 'c': this.laColumna = 3; break;
			case 'D': case 'd': this.laColumna = 4; break;
			case 'E': case 'e': this.laColumna = 5; break;
			case 'F': case 'f': this.laColumna = 6; break;
			case 'G': case 'g': this.laColumna = 7; break;
			case 'H': case 'h': this.laColumna = 8; break;
			default: throw new Exception("No estás usando la notación internacional");
		}	
	}
	
	public int fila() {
		return laFila;
	}
	
	public int columna() {
		return laColumna;
	}
	
	public boolean equals(Posicion posicion) {
		if (this.laFila == posicion.fila() && this.laColumna == posicion.columna()) {
			return true;
		}else {return false;}	
	}

}
