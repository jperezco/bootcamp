package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * Clase simple para realizar cálculos acumulados.
 *
 * @author Javier
 */
public class Calculadora {
	/**
	 * Lista de las operaciones soportadas
	 */
	public static final String OPERACIONES_SOPORTADAS = "+-*/=%";

	private double acumulado;
	private char operadorPendiente;

	/**
	 * Constructor por defecto
	 */
	public Calculadora() {
		inicializa();
	}

	/**
	 * Restaura el valor inicial para calcular la siguiente secuencia
	 */
	public void inicializa() {
		acumulado = 0;
		operadorPendiente = '+';
	}

	/**
	 * Obtiene el total acumulado hasta el momento.
	 * 
	 * @return Valor acumulado
	 */
	public double getAcumulado() {
		return acumulado;
	}

	/**
	 * Comprueba que sea una de las operaciones soportadas por la calculadora.
	 * 
	 * @param operacion Símbolo de la operación
	 * @return true si la soporta, false en el resto de los casos.
	 */
	public boolean isOperacion(char operacion) {
		return OPERACIONES_SOPORTADAS.indexOf(operacion) != -1;
	}

	/**
	 * Realiza la operación pendiente una vez obtenido el segundo operador y guarda
	 * la nueva operación pendiente
	 * 
	 * @param operando2     segundo operador
	 * @param nuevoOperador la nueva operación pendiente
	 * @return el total acumulado hasta el momento
	 * @throws Exception Cuando el símbolo de operación no esta soportado
	 */
	public double calcula(double operando2, char nuevoOperador) throws CalculadoraException {
		if (!isOperacion(nuevoOperador)) {
			throw new CalculadoraException("Operación no soportada.");
		}
		switch (operadorPendiente) {
		case '+':
			acumulado += operando2;
			break;
		case '-':
			acumulado -= operando2;
			break;
		case '*':
			acumulado *= operando2;
			break;
		case '/':
			acumulado /= operando2;
			break;
		case '%':
			acumulado %= operando2;
			break;
		case '=':
			acumulado += operando2;
			break;
		default:
			throw new CalculadoraException("Operación no soportada.");
		}
		this.operadorPendiente = nuevoOperador;
		return acumulado;
	}

	public static void decode(String expresion) {
		if (expresion == null || "".equals(expresion) || !Character.isDigit(expresion.charAt(0)))
			throw new java.lang.IllegalArgumentException("No es una expresión valida");
		String operando = "";
		for (int i = 0; i < expresion.length(); i++) {
			char ch = expresion.charAt(i);
			if (Character.isDigit(ch)) {
				operando += ch;
			} else if (ch == ',') {
				if (operando.indexOf(ch) == -1) {
					operando += ch;
				} else {
					// throw new Exception("Ya existe separador decimal.");
				}
			} else if ("+-*/%=".indexOf(ch) >= 0) {
				if (operando.endsWith(",")) {
					operando += "0";
				}
				System.out.println(operando + " " + ch);
				if (ch == '=') {
					break;
				}
				operando = "";
			} else if (ch != ' ') {
//				throw new Exception("Carácter no valido.");
			}
		}
	}

	/**
	 * Sobrecarga
	 * 
	 * @see Calculadora#calcula(double, char)
	 * @param operando2      segundo operador
	 * @param nuevaOperacion la nueva operación pendiente
	 * @return el total acumulado hasta el momento
	 * @throws Exception Cuando el símbolo de operación no esta soportado
	 */
	public double calcula(String operando2, char nuevoOperador) throws CalculadoraException {
		if (operando2.endsWith(",") || operando2.endsWith(".")) {
			operando2 += "0";
		}
		try {
			return calcula(Double.parseDouble(operando2.replace(',', '.')), nuevoOperador);
		} catch (NumberFormatException ex) {
			throw new CalculadoraException("El operando no tienen un formato númerico valido.", ex);
		}
	}

	public static class Operacion {
		private double operando;
		private char operador;

		public Operacion(double operando, char operador) {
			super();
			this.operando = operando;
			this.operador = operador;
		}

		public Operacion(String operando, char operador) {
			this(Double.parseDouble(operando.replace(',', '.')), operador);
		}

		public double getOperando() {
			return operando;
		}

		public char getOperador() {
			return operador;
		}
	}

	public double calcula(List<Operacion> operaciones) throws CalculadoraException {
		inicializa();
		for (Operacion operacion : operaciones) {
			calcula(operacion.getOperando(), operacion.getOperador());
		}
		return acumulado;
	}

	public String leeFichero() {

		File cadena = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			cadena = new File("C:\\Eclipse\\Cadena.txt");
			fr = new FileReader(cadena);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;

			linea = br.readLine();

			return linea;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
}