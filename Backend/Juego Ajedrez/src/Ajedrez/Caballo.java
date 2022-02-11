package Ajedrez;

public class Caballo extends Pieza{
	
	public Caballo (Color color) {
		super(color);
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		int diferenciaDeSalto;
		diferenciaDeSalto = Math.abs(movimiento.saltoHorizontal())
				- Math.abs(movimiento.saltoVertical()); 
		if (diferenciaDeSalto == 1 && tablero.hayPiezasEntre(movimiento) == false ||
				diferenciaDeSalto == -1 && tablero.hayPiezasEntre(movimiento) == false) {
			return true;
		} else {return false;}
	}

}
