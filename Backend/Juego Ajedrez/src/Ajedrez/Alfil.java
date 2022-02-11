package Ajedrez;

public class Alfil extends Pieza{
	
	public Alfil (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.esDiagonal() && tablero.hayPiezasEntre(movimiento) == false) {
			return true;
		} else {return false;}
	}

}
