package Ajedrez;

/**
 * Esta clase est� construida para manejar todo el movimiento relacionado con las
 * piezas del ajedrez.
 * @author Javier P�rez C�rdoba.
 *
 */


public class Movimiento {
	
	private Posicion posIni;
	private Posicion posFin;
	
	/**
	 * El constructor del m�todo, que se encarga de definir las posiciones inicial y final
	 * del movimiento.
	 * @param movimiento Una cadena que debe cumplir la notaci�n internacional. Por ejemplo
	 *                   "a3b7", donde los dos primeros caracteres se corresponden con 
	 *                   columna y fila inicial y los dos �ltimos con columna y fila final.
	 * @throws Exception Para cumplir con la notaci�n internacional la cadena ha de ser de
	 *                   cuatro caracteres, ni m�s ni menos. Adem�s, las posiciones inicial
	 *                   y final han de ser distintas.
	 */
	
	public Movimiento(String movimiento) throws Exception{
		if (movimiento.length() != 4 || movimiento == null) {
			throw new Exception("No est�s usando notaci�n internacional");
		}
		
		posIni = new Posicion(movimiento.charAt(1), movimiento.charAt(0));
		posFin = new Posicion(movimiento.charAt(3), movimiento.charAt(2));
		
		if (posIni.equals(posFin)) {
			throw new Exception("Las posciones inicial y final son las mismas. No hay "
					+ "movimiento");
		}
	}
	
	/**
	 * M�todo que devueve la posici�n inicial del movimiento.
	 * @return Posicion
	 */
	
	public Posicion posicionInicial() {
		return posIni;
	}
	
	/**
	 * M�todo que devuelve la posici�n final del movimiento.
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
	 * Indica cu�ntos saltos de columna ha tenido el movimiento.
	 * @return int.
	 */
	
	public int saltoHorizontal() {
		return posFin.columna() - posIni.columna();
	}
	
	/**
	 * Indica cu�ntos saltos de columna ha tenido el movimiento.
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
	 * M�todo que indica si el movimiento implica un salto de columna hacia la derecha, un
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
	 * M�todo que indica si el movimiento implica un salto de fila hacia arriba, un
	 * salto de fila hacia abajo o si no hay salto de fila.
	 * @return Un 1 si es abajo. Un -1 si es arriba. Un 0 si no hay salto de fila.
	 */
	
	public int deltaFila() {
		if (saltoVertical() > 0) {return 1;}
		else if (saltoVertical() < 0) {return -1;}
		else {return 0;}		
	}

}
