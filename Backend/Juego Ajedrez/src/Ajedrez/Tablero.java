package Ajedrez;

public class Tablero {

	private Pieza[][] piezas = new Pieza[8][8];
		
	public Pieza damePieza(int fila, int columna) throws Exception{
		
		if (esValido(fila)) {}
		else {
			throw new Exception("La fila debe estar entre 1 y 8");
		}
		
		if (esValido(columna)) {} 
		else {
			throw new Exception("La columna debe estar entre 1 y 8");
		}
		
		if (hayPieza(fila, columna)) {
			return piezas[fila-1][columna-1];
		} else {
			throw new Exception("No tienes ninguna pieza en ese escaque");
		}
	}
	
	public Pieza damePieza(Posicion posicion) throws Exception{
		
		if (hayPieza(posicion)) {
			return piezas[posicion.fila()-1][posicion.columna()-1];
		} else {
			throw new Exception("No tienes ninguna pieza en ese escaque");
		}
	
	}
	

	public void ponPieza(Pieza pieza, int fila, int columna) throws Exception{
		
		if (esValido(fila)) {}
		else {
			throw new Exception("La fila debe estar entre 1 y 8");
		}
		
		if (esValido(columna)) {} 
		else {
			throw new Exception("La columna debe estar entre 1 y 8");
		}
		
		if (hayPieza(fila, columna)) {
			throw new Exception("Ya hay una pieza en esa casilla");
		} else {
			piezas[fila-1][columna-1] = pieza;
		}		
	}
	
	
	public void ponPieza(Pieza pieza, Posicion posicion) throws Exception{
		
		if (hayPieza(posicion)) {
			throw new Exception("Ya hay una pieza en esa casilla");
		} else {
			piezas[posicion.fila()-1][posicion.columna()-1] = pieza;
		}		
	}
	
	
	private boolean esValido(int i) {
		if (i < 1 || i > 8) {
			return true;
		} else {return false;}
	}
	
	public boolean hayPieza(int fila, int columna) {
		if (piezas[fila-1][columna-1] == null) {
			return false;
		}else {return true;}		
	}
	
	public boolean hayPieza(Posicion posicion) {
		if (piezas[posicion.fila()-1][posicion.columna()-1] == null) {
			return false;
		}else {return true;}		
	}
	
	public void quitaPieza(int fila, int columna) throws Exception{
		if (hayPieza(fila, columna)) {
			piezas[fila-1][columna-1] = null;
		} else {
			throw new Exception("No hay pieza que quitar");
		}
	}
	
	public void quitaPieza(Posicion posicion) throws Exception{
		if (hayPieza(posicion)) {
			piezas[posicion.fila()-1][posicion.columna()-1] = null;
		} else {
			throw new Exception("No hay pieza que quitar");
		}
	}
	
	public void mover(Movimiento movimiento) throws Exception{
		
		if (hayPieza(movimiento.posicionInicial()) == false) {
			throw new Exception("No hay pieza que mover");
		} else if(hayPiezasEntre(movimiento)) {
			throw new Exception("No puedes realizar el movimiento porque hay piezas"
					+ " entre las casillas inicial y final.");
		} else {		
		piezas[movimiento.posicionFinal().fila()-1][movimiento.posicionFinal().columna()-1] = 
				piezas[movimiento.posicionInicial().fila()-1][movimiento.posicionInicial().columna()-1];
		quitaPieza(movimiento.posicionInicial());		
		}
		
	}
	
	public Object clone() {
		return piezas.clone();
	}
	
	public Color colorEscaque(int fila, int columna) throws Exception{
		
		if (hayPieza(fila, columna)) {
			return piezas[fila-1][columna-1].dameColor();
		} else {
			throw new Exception("No hay pieza en esa casilla");
		}
	}
	
	public boolean hayPiezasEntre(Movimiento movimiento) {				
		int filaActualizable, columnaActualizable;
		filaActualizable = movimiento.posicionInicial().fila();
		columnaActualizable = movimiento.posicionInicial().columna();

		
		while (filaActualizable != movimiento.posicionFinal().fila() &&
				columnaActualizable != movimiento.posicionFinal().columna()) {
			filaActualizable += movimiento.deltaFila();
			columnaActualizable += movimiento.deltaColumna();
			
			if (filaActualizable == movimiento.posicionFinal().fila() &&
					columnaActualizable == movimiento.posicionFinal().columna()) {
				return false;
			}
			
			if (hayPieza(filaActualizable, columnaActualizable)) {
				return true;
			}
		}
		return false;
	}

}
