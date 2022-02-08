package Ajedrez;

public enum Color {
	BLANCO(1), NEGRO(2);
	
	private int numeroAsociado;
	
	private Color(int numeroAsociado) {
		this.numeroAsociado = numeroAsociado;
		
	}
	
	public int dameNumeroAsociado() {
		return numeroAsociado;
	}

}
