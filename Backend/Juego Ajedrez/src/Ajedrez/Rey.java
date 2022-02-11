package Ajedrez;

public class Rey extends Pieza{
	
	public Rey (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.esHorizontal() && Math.abs(movimiento.saltoHorizontal()) == 1 &&
			tablero.hayPiezasEntre(movimiento) == false || movimiento.esVertical() &&
			Math.abs(movimiento.saltoVertical()) == 1 &&
			tablero.hayPiezasEntre(movimiento) == false) {
			return true;
		}else {return false;}
	}
}
