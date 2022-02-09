package Ajedrez;

public class Torre extends Pieza{
	
	public Torre (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		return true;
	}

}
