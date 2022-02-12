package Ajedrez;

public class Peon extends Pieza{
	
	public Peon (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		return true;
	}
	
	private boolean avanza(Movimiento movimiento) {
		if (dameColor() == Color.BLANCO && movimiento.deltaColumna() == 1 || 
				dameColor() == Color.NEGRO && movimiento.deltaColumna() == -1) {
			return true;
		} else {return false;}
	}
	
	private boolean inicia(Posicion posicion) {
		if (dameColor() == Color.BLANCO && posicion.fila() == 2 ||
				dameColor() == Color.NEGRO && posicion.fila() == 7) {
			return true;
		} else {return false;}
	}
}
