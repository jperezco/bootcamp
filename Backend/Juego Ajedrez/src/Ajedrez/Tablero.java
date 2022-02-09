package Ajedrez;

public class Tablero {

	private Pieza[][] piezas = new Pieza[8][8];
	
//	piezas[0][0] = new Torre(blancas);
//	piezas[0][1] = new Caballo(blancas);
//	piezas[0][2] = new Alfil(blancas);
//	piezas[0][3] = new Dama(blancas);
//	piezas[0][4] = new Rey(blancas);
//	piezas[0][5] = new Alfil(blancas);
//	piezas[0][6] = new Caballo(blancas);
//	piezas[0][7] = new Torre(blancas);
//	for (int i = 0; i <= 7; i++) {
//		piezas[1][i] = new Peon(blancas);
//	}
//	
//	piezas[7][0] = new Torre(negras);
//	piezas[7][1] = new Caballo(negras);
//	piezas[7][2] = new Alfil(negras);
//	piezas[7][3] = new Dama(negras);
//	piezas[7][4] = new Rey(negras);
//	piezas[7][5] = new Alfil(negras);
//	piezas[7][6] = new Caballo(negras);
//	piezas[7][7] = new Torre(negras);
//	for (int i = 0; i <= 7; i++) {
//		piezas[6][i] = new Peon(negras);
//	}
//	
	
	public Pieza escaque(int fila, int columna) throws Exception{
		
		if (esValido(fila)) {
			fila -= 1;
		} else {
			throw new Exception("La fila debe estar entre 1 y 8");
		}
		
		if (esValido(columna)) {
			columna -= 1;
		} else {
			throw new Exception("La columna debe estar entre 1 y 8");
		}
		
		if (hayPieza(fila, columna)) {
			return piezas[fila][columna];
		} else {
			throw new Exception("No tienes ninguna pieza en ese escaque");
		}
	}
	
	public Pieza escaque(Posicion posicion) throws Exception{
		if (hayPieza(posicion)) {
			return piezas[posicion.fila()-1][posicion.columna()-1];
		} else {
			throw new Exception("No tienes ninguna pieza en ese escaque");
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
	
	public void quitaPieza(int fila, int columna) {
		if (hayPieza(fila, columna)) {
			

		}
	}
	
	public void quitaPieza(Posicion posicion) {
		if (escaque(fila, columna) instanceof Pieza) {

		}
	}

}
