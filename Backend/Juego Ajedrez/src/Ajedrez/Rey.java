package Ajedrez;

public class Rey extends Pieza{
	
	public Rey (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws Exception{
		if (Math.abs(movimiento.saltoHorizontal()) == 1 || 
				Math.abs(movimiento.saltoVertical()) == 1) {
			return true;
		} else {return false;}
	}
}
