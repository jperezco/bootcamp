package capgemini;

public class Prueba {

	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();
		String cadena = "3+4+3.4-7*1=";
		System.out.println(calculadora.calcular(cadena));

	}

}
