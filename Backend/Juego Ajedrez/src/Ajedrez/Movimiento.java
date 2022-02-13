package Ajedrez;

/**
 * Esta clase está construida para manejar todo el movimiento relacionado con las
 * piezas del ajedrez.
 * @author Javier Pérez Córdoba.
 *
 */


public class Movimiento {
	
	private Posicion posIni;
	private Posicion posFin;
	
	/**
	 * El constructor del método, que se encarga de definir las posiciones inicial y final
	 * del movimiento.
	 * @param movimiento Una cadena que debe cumplir la notación internacional. Por ejemplo
	 *                   "a3b7", donde los dos primeros caracteres se corresponden con 
	 *                   columna y fila inicial y los dos últimos con columna y fila final.
	 * @throws Exception Para cumplir con la notación internacional la cadena ha de ser de
	 *                   cuatro caracteres, ni más ni menos. Además, las posiciones inicial
	 *                   y final han de ser distintas.
	 */
	
	public Movimiento(String movimiento) throws Exception{
		if (movimiento.length() != 4 || movimiento == null) {
			throw new Exception("No estás usando notación internacional");
		}
		
		posIni = new Posicion(movimiento.charAt(1), movimiento.charAt(0));
		posFin = new Posicion(movimiento.charAt(3), movimiento.charAt(2));
		
		if (posIni.equals(posFin)) {
			throw new Exception("Las posciones inicial y final son las mismas. No hay "
					+ "movimiento");
		}
	}
	
	/**
	 * Método que devueve la posición inicial del movimiento.
	 * @return Posicion
	 */
	
	public Posicion posicionInicial() {
		return posIni;
	}
	
	/**
	 * Método que devuelve la posición final del movimiento.
	 * @return Posicion
	 */
	
	public Posicion posicionFinal() {
		return posFin;
	}
	
	/**
	 * Indica si el movimiento es vertical.
	 * @return boolean
	 */
	
	public boolean esVertical() {
		if (posIni.fila() != posFin.fila() && posIni.columna() == posFin.columna()) {
			return true;
		}else{return false;}
	}
	
	/**
	 * Indica si el movimiento es horizontal.
	 * @return boolean
	 */
	
	public boolean esHorizontal() {
		if (posIni.fila() == posFin.fila() && posIni.columna() != posFin.columna()) {
			return true;
		}else{return false;}
	}
	
	/**
	 * Indica cuántos saltos de columna ha tenido el movimiento.
	 * @return int.
	 */
	
	public int saltoHorizontal() {
		return posFin.columna() - posIni.columna();
	}
	
	/**
	 * Indica cuántos saltos de columna ha tenido el movimiento.
	 * @return int
	 */
	
	public int saltoVertical() {
		return posFin.fila() - posIni.fila();
	}
	
	/**
	 * Indica si el movimiento ha sido diagonal o no.
	 * @return boolean
	 */
	
	public boolean esDiagonal() {
		if (Math.abs(saltoVertical()) == Math.abs(saltoHorizontal())) {
			return true;
		}else {return false;}
	}
	
	/**
	 * Método que indica si el movimiento implica un salto de columna hacia la derecha, un
	 * salto de columna hacia la izquierda o si no hay salto de columna.
	 * @return Un 1 si es a la derecha. Un -1 si es hacia la izquierda. Un 0 si no hay
	 * 		   salto de columna.
	 */
	
	public int deltaColumna() {
		if (saltoHorizontal() > 0) {return 1;}
		else if (saltoHorizontal() < 0) {return -1;}
		else {return 0;}		
	}
	
	/**
	 * Método que indica si el movimiento implica un salto de fila hacia arriba, un
	 * salto de fila hacia abajo o si no hay salto de fila.
	 * @return Un 1 si es abajo. Un -1 si es arriba. Un 0 si no hay salto de fila.
	 */
	
	public int deltaFila() {
		if (saltoVertical() > 0) {return 1;}
		else if (saltoVertical() < 0) {return -1;}
		else {return 0;}		
	}

}
