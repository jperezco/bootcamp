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
			case 'A': case 'a': this.laColumna = 1;
			case 'B': case 'b': this.laColumna = 2;
			case 'C': case 'c': this.laColumna = 3;
			case 'D': case 'd': this.laColumna = 4;
			case 'E': case 'e': this.laColumna = 5;
			case 'F': case 'f': this.laColumna = 6;
			case 'G': case 'g': this.laColumna = 7;
			case 'H': case 'h': this.laColumna = 8;
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
		if (this.laFila == posicion.laFila && this.laColumna == posicion.laColumna) {
			return true;
		}else {return false;}	
	}

}
