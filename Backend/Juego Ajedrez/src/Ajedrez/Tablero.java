package Ajedrez;

public class Tablero {

	private Pieza[][] piezas = new Pieza[8][8];
		
	public Pieza damePieza(int fila, int columna) throws Exception{			
		if (!esValido(fila))
			throw new Exception("La fila debe estar entre 1 y 8");	
		if (!esValido(columna)) 
			throw new Exception("La columna debe estar entre 1 y 8");		
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
		if (!esValido(fila)) 
			throw new Exception("La fila debe estar entre 1 y 8");
		if (!esValido(columna)) 
			throw new Exception("La columna debe estar entre 1 y 8");		
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
			return false;
		} else {return true;}
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
		if (!hayPieza(movimiento.posicionInicial())) {
			throw new Exception("No hay pieza que mover");
		} else if(hayPiezasEntre(movimiento)) {
			throw new Exception("No puedes realizar el movimiento porque hay piezas"
					+ " entre las casillas inicial y final.");
		} else {			
		ponPieza(piezas[movimiento.posicionFinal().fila()-1]
				[movimiento.posicionFinal().columna()-1], movimiento.posicionFinal());
		quitaPieza(movimiento.posicionInicial());		
		}		
	}

	
	public Tablero clone() {
		return this.clone();
	}
	
	
	public Color colorEscaque(int fila, int columna) throws Exception{
		if ((columna % 2) == (fila % 2)) {
			return Color.BLANCO;
		} else {
			return Color.NEGRO;
		}
	}
	
	
	public boolean hayPiezasEntre(Movimiento movimiento) throws Exception{				
		if (!movimiento.esVertical() && !movimiento.esHorizontal() && 
				!movimiento.esDiagonal())
			throw new Exception("No se puede realizar el movimiento");
		Posicion siguiente = new Posicion(movimiento.posicionInicial().fila() + 
				movimiento.deltaFila(), movimiento.posicionInicial().columna() +
				movimiento.deltaColumna());		
		while(!siguiente.equals(movimiento.posicionFinal())) {
			if(hayPieza(siguiente))
				return true;
			siguiente = new Posicion(siguiente.fila() + movimiento.deltaFila(),
					siguiente.columna() + movimiento.deltaColumna());
		}
		return false;
	}

}
