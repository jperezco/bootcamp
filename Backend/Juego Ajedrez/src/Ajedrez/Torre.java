package Ajedrez;

public class Torre extends Pieza{
	
	public Torre (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.esHorizontal() && tablero.hayPiezasEntre(movimiento) == false) {
			return true;
		} else {return false;}
	}

}
