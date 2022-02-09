package Ajedrez;

public class Dama extends Pieza{
	
	public Dama (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		return true;
	}

}
