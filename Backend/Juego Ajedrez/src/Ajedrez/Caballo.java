package Ajedrez;

public class Caballo extends Pieza{
	
	public Caballo (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws Exception{
		int diferenciaDeSalto;
		diferenciaDeSalto = Math.abs(movimiento.saltoHorizontal())
				- Math.abs(movimiento.saltoVertical()); 
		if (diferenciaDeSalto == 1 && !tablero.hayPiezasEntre(movimiento) ||
				diferenciaDeSalto == -1 && !tablero.hayPiezasEntre(movimiento)) {
			return true;
		} else {return false;}
	}

}
