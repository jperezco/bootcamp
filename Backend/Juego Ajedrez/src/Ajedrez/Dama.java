package Ajedrez;

public class Dama extends Pieza{
	
	public Dama (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws Exception{
		if (movimiento.esHorizontal() && !tablero.hayPiezasEntre(movimiento) ||
			movimiento.esVertical() && !tablero.hayPiezasEntre(movimiento) ||
			movimiento.esDiagonal() && !tablero.hayPiezasEntre(movimiento)) {			
			return true;
		} else {return false;}
	}

}
