package Ajedrez;

public class Torre extends Pieza{
	
	public Torre (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws Exception{
		if (movimiento.esHorizontal() && !tablero.hayPiezasEntre(movimiento) ||
				movimiento.esVertical() && !tablero.hayPiezasEntre(movimiento)) {
			return true;
		} else {return false;}
	}

}
