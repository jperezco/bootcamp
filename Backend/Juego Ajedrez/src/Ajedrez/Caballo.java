package Ajedrez;

public class Caballo extends Pieza{
	
	public Caballo (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		return true;
	}

}
