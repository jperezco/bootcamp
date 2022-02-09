package Ajedrez;

public class Peon extends Pieza{
	
	public Peon (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		return true;
	}

}
