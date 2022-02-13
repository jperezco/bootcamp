package Ajedrez;

public abstract class Pieza {
	
	private Color color;
			
	public Pieza(Color color) {
		this.color = color;
	}
	
	public Color dameColor() {
		return color;
	}
	
	protected abstract boolean esValido(Movimiento movimiento, Tablero tablero) 
			throws Exception;
	
	public void mover(Movimiento movimiento, Tablero tablero) throws Exception{
		
	}

}
