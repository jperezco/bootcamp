package Ajedrez;

public class Movimiento {
	
	private Posicion posIni;
	private Posicion posFin;
	
	public Movimiento(String movimiento) throws Exception{
		posIni = new Posicion(movimiento.charAt(1), movimiento.charAt(0));
		posFin = new Posicion(movimiento.charAt(3), movimiento.charAt(2));		
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
	
	

}
