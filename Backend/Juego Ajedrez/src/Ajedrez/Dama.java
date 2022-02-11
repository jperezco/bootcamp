package Ajedrez;

public class Dama extends Pieza{
	
	public Dama (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.esHorizontal() && tablero.hayPiezasEntre(movimiento) == false ||
			movimiento.esVertical() && tablero.hayPiezasEntre(movimiento) == false ||
			movimiento.esDiagonal() && tablero.hayPiezasEntre(movimiento) == false) {
			
			return true;
			
		} else {return false;}
	}

}
