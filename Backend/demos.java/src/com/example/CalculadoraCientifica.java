package com.example;

public class CalculadoraCientifica extends Calculadora {
	public CalculadoraCientifica() {
		int i=0;
		this(0);
	}
	public CalculadoraCientifica(int i) {
		super(i);
	}
	public double divide(double a, double b) {
		return a/b;
	}
	@Override
	// Podemos sobreescribir el metodo heredado del padre
	public int suma(int a, int b) {
		return a-b;
	}
	
	
	// Los contadores son diferentes. EL metodo utiliza el más local, que es su propio parámetro. Con el this 
	// cogemos el primero.
	private int contador=0;
	
	public void inicializa(int contador) {
		this.contador = contador;
	}

}
