package com.example;

public class Calculadora {
	// COnstante de valor 1. No se puede cambiar
	public static final int CONSTANTE = 1;
	//final int readOnly;
	private static Calculadora calculadora = null;
	public static Calculadora getCurrent() {
		if(calculadora == null)
			calculadora = new Calculadora();
		return calculadora;	
	}	
	//Método que se llama como la clase: constructor. Al ponerle private no se puede instanciar fuera de la propia
	//clase.
//	private Calculadora() {};
	public Calculadora(int algo) {};
	
	
	public int suma(int a, int b) {
		return a + b;
	}
	public static double suma(double a, double b) {
		return a + b;
    }
	

// La lista ha de tener un elemento obligatorio.
	public double avg(double primero, double ... resto) {
		if(resto.length == 0) return primero;	
		double acumula= primero;
		for(int i=0; i < resto.length; acumula += resto[i++]);
		//for(double valor: resto) acumula += valor;
		return acumula / resto.length;
	}

}
