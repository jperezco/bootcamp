/**
 * 
 */
package com.example;

/**
 * @author jperezco
 *
 */
public class Principal {
	public static void main(String[] args) {
		Dias dia = Dias.DOMINGO;
		String s = "Hola";
		s += " mundo";
		System.out.println(dia);
		Calculadora c = Calculadora.getCurrent();
//		System.out.println(c.avg());
		System.out.println(c.avg(5));
		System.out.println(c.avg(1,2,3,4,5));
		double i = Calculadora.suma(0.0, 5.0);
		CalculadoraCientifica cc = new CalculadoraCientifica();
		System.out.println(cc.divide(7.0,2.0));
	}
	Grafico grafico;
	grafico.pintate();

}
