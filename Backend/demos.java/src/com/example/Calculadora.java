package com.example;

public class Calculadora {
	public static final int CONSTANTE = 1;
	final int readOnly;
	
	private static Calculadora calculadora = null;
	
	static {
		Calculadora calculadora = new Calculadora(1);
	}
	
	public static Calculadora getCurrent() {
		if(calculadora == null)
			calculadora = new Calculadora(0);
		return calculadora;
	}
	
	// private Calculadora() {}
	public Calculadora(int algo) {
		readOnly = algo;
	}
	
	public int suma(int a, int b) {
		return a + b;
	}
	
	public static int divideEnteros(int a, int b) {
		return a/b;
	}
	
	public static double divideDecimales(double a, double b) {
		if(b==0)
			throw new ArithmeticException("/by zero");
		return a/b;
	}
//	public int suma(int a) {
//		return a + a;
//	}
	public static double suma(double a, double b) {
		return a + b;
	}
	
//	public double avg(double... resto) {
//		if(resto.length == 0) return 0;
//		if(resto.length == 1) return resto[0];
//		double acumula = 0.0;
//		for(int i=0; i < resto.length; acumula += resto[i++]);
//		//for(double valor: resto) acumula += valor;
//		return acumula / resto.length;
//	}
	public double avg(double primero, double... resto) {
		if(resto.length == 0) return primero;
		double acumula = primero;
		for(int i=0; i < resto.length; acumula += resto[i++]);
		//for(double valor: resto) acumula += valor;
		return acumula / resto.length;
	}
}
