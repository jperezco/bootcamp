package Ajedrez;

public class Caballo extends Pieza{
	
	public Caballo (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws Exception{
		if (Math.abs(movimiento.saltoVertical()) == 2 &&
				Math.abs(movimiento.saltoHorizontal()) == 1 ||
				Math.abs(movimiento.saltoVertical()) == 1 &&
				Math.abs(movimiento.saltoHorizontal()) == 2) {
			return true;
		} else {return false;}
	}

}
