package Ajedrez;

public class Movimiento {
	
	private Posicion posIni;
	private Posicion posFin;
	
	public Movimiento(String movimiento) throws Exception{
		posIni = new Posicion(movimiento.charAt(1), movimiento.charAt(0));
		posFin = new Posicion(movimiento.charAt(3), movimiento.charAt(2));
		if (posIni.equals(posFin) && posIni != null && posFin != null) {
			throw new Exception("O las posiciones iniciales y finales son las mimsas "
					+ "o no las has introducido con un formato correcto");
		}
	}
	
	public Posicion posicionInicial() {
		return posIni;
	}
	
	public Posicion posicionFinal() {
		return posFin;
	}
	
	public boolean esVertical() {
		if (posIni.fila() != posFin.fila() && posIni.columna() == posFin.columna()) {
			return true;
		}else{return false;}
	}
	
	public boolean esHorizontal() {
		if (posIni.fila() == posFin.fila() && posIni.columna() != posFin.columna()) {
			return true;
		}else{return false;}
	}
	
	public int saltoVertical() {
		return posFin.columna() - posIni.columna();
	}
	
	public int saltoHorizontal() {
		return posFin.fila() - posIni.fila();
	}
	
	public boolean esDiagonal() {
		if (Math.abs(saltoVertical()) == Math.abs(saltoHorizontal())) {
			return true;
		}else {return false;}
	}
	
	public int deltaFila() {
		if (saltoHorizontal() > 0) {return 1;}
		else if (saltoHorizontal() < 0) {return -1;}
		else {return 0;}		
	}
	
	public int deltaColumna() {
		if (saltoVertical() > 0) {return 1;}
		else if (saltoVertical() < 0) {return -1;}
		else {return 0;}		
	}

}
