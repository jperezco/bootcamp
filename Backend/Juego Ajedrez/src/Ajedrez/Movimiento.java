package Ajedrez;

public class Movimiento {
	
	private Posicion posIni;
	private Posicion posFin;
	
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
