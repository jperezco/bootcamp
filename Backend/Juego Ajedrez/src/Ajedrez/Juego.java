package Ajedrez;

public class Juego {
	
	private Tablero elTablero;
	private Color elTurno;
	private boolean partidaActiva = false;
	
	public Tablero dameTablero() {
		return elTablero.clone();
	}
	
	public Color dameTurno() {
		return elTurno;
	}
	
	public void inicializar() throws Exception{
		
		Tablero elTablero = new Tablero();
		
		Torre torreBlanca = new Torre(Color.BLANCO);
		Caballo caballoBlanca = new Caballo(Color.BLANCO);
		Alfil alfilBlanca = new Alfil(Color.BLANCO);
		Dama damaBlanca = new Dama(Color.BLANCO);
		Rey reyBlanca = new Rey(Color.BLANCO);
		Peon peonBlanca = new Peon(Color.BLANCO);
		
		elTablero.ponPieza(torreBlanca, 1, 1);
		elTablero.ponPieza(caballoBlanca, 1, 2);
		elTablero.ponPieza(alfilBlanca, 1, 3);
		elTablero.ponPieza(damaBlanca, 1, 4);
		elTablero.ponPieza(reyBlanca, 1, 5);
		elTablero.ponPieza(alfilBlanca, 1, 6);
		elTablero.ponPieza(caballoBlanca, 1, 7);
		elTablero.ponPieza(torreBlanca, 1, 8);		
		for (int i = 1; i <= 8; i++) {
			elTablero.ponPieza(peonBlanca, 2, i);
		}
		
		Torre torreNegra = new Torre(Color.NEGRO);
		Caballo caballoNegra = new Caballo(Color.NEGRO);
		Alfil alfilNegra = new Alfil(Color.NEGRO);
		Dama damaNegra = new Dama(Color.NEGRO);
		Rey reyNegra = new Rey(Color.NEGRO);
		Peon peonNegra = new Peon(Color.NEGRO);
		
		elTablero.ponPieza(torreNegra, 8, 1);
		elTablero.ponPieza(caballoNegra, 8, 2);
		elTablero.ponPieza(alfilNegra, 8, 3);
		elTablero.ponPieza(damaNegra, 8, 4);
		elTablero.ponPieza(reyNegra, 8, 5);
		elTablero.ponPieza(alfilNegra, 8, 6);
		elTablero.ponPieza(caballoNegra, 8, 7);
		elTablero.ponPieza(torreNegra, 8, 8);
		for (int i = 1; i <= 8; i++) {
			elTablero.ponPieza(peonNegra, 7, i);
		}
		
		partidaActiva = true;
		elTurno = Color.BLANCO;
		
	}
	
	public void jugada(String jugada) throws Exception{
		Movimiento movimiento = new Movimiento(jugada);
		if (!elTablero.hayPieza(movimiento.posicionInicial()))
			throw new Exception("No hay pieza que mover");
		if (elTablero.damePieza(movimiento.posicionInicial()).dameColor() != elTurno)
			throw new Exception("Estás intentando mover una pieza que no es tuya.");
		if (elTablero.hayPieza(movimiento.posicionFinal()) && 
				elTablero.damePieza(movimiento.posicionFinal()).dameColor() == elTurno)
			throw new Exception("No te puedes comer una pieza de tu propio color.");				
		mover(movimiento);
		cambiaTurno();
	}
	
	private void mover(Movimiento movimiento) throws Exception{
		elTablero.damePieza(movimiento.posicionInicial()).mover(movimiento, elTablero);
	}
	
	private void cambiaTurno() {
		if (elTurno == Color.BLANCO) {
			elTurno = Color.NEGRO;
		} else {elTurno = Color.BLANCO;}
	}

}
