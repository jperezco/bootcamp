package Ajedrez;

public class Peon extends Pieza{
	
	public Peon (Color color) {
		super(color);
	}
	
	private boolean avanza(Movimiento movimiento) {
		if (dameColor() == Color.BLANCO && movimiento.deltaFila() == 1 || 
				dameColor() == Color.NEGRO && movimiento.deltaFila() == -1) {
			return true;
		} else {return false;}
	}
	
	private boolean inicia(Posicion posicion) {
		if (dameColor() == Color.BLANCO && posicion.fila() == 2 ||
				dameColor() == Color.NEGRO && posicion.fila() == 7) {
			return true;
		} else {return false;}
	}
	
	private boolean puedeComer(Movimiento movimiento, Tablero tablero) throws Exception{
		if(avanza(movimiento) && movimiento.esDiagonal() && 
				tablero.hayPieza(movimiento.posicionFinal()) &&
				tablero.colorEscaque(movimiento.posicionFinal().fila(), 
						movimiento.posicionFinal().columna()) != dameColor()) {
			return true;
		} else {return false;}
	}
	
	private boolean necesitaPromocion(Posicion posicion) {
		if (dameColor() == Color.BLANCO && posicion.fila() == 8 ||
				dameColor() == Color.NEGRO && posicion.fila() == 1) {
			return true;
		} else {return false;}
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws Exception{
		if (inicia(movimiento.posicionInicial()) && avanza(movimiento) && 
				!tablero.hayPiezasEntre(movimiento) && movimiento.esVertical()
				&& movimiento.saltoVertical() == 2) {
			return true;
		} 
		else if (avanza(movimiento) && movimiento.esVertical() && 
				movimiento.saltoVertical() == 1) 
		{return true;}
		else if (avanza(movimiento) && puedeComer(movimiento, tablero) &&
				movimiento.saltoHorizontal() == 1 && movimiento.saltoVertical() == 1) 
		{return true;}
		else {return false;}
	}
	
	public void mover(Movimiento movimiento, Tablero tablero) throws Exception{
		if (esValido(movimiento, tablero)) {
			tablero.mover(movimiento);
		}
	}
		
}
