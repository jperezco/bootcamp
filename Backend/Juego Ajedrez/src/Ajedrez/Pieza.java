package Ajedrez;

public abstract class Pieza {
	
	Color color;
			
	public Pieza(Color color) {
		this.color = color;
	}
	
	public Color dameColor() {
		return color;
	}
	
	protected abstract boolean esValido(Movimiento movimiento, Tablero tablero);
	
	public void mover(Movimiento movimiento, Tablero tablero) {
		
	}

}