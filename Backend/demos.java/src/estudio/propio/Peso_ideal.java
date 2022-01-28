package estudio.propio;
//Importamos todo el paquete javax.swing, que tendrá sus clases correspondientes.
import javax.swing.*;

public class Peso_ideal {
	public static void main(String[] args) {
		//Creamos una variable genero donde lo guardaremos.
		String genero="";
		do {
			//Usamos el método showInputDialog de la clase JOptionPane para que el usuario introduzca su genero
			//y lo guardamos en su clase correspondiente.
			genero=JOptionPane.showInputDialog("Introduce tu género  (H/M)");
			//Usamos el método equalsIgnoreCase de la clase String para comparar H y M con lo que ha puesto el usuario.
			//Como el metodo no es estatico no necesitamos nombrar la clase.
		} while(genero.equalsIgnoreCase("H") == false && genero.equalsIgnoreCase("M") == false);
		
		//Clase JOptionPane con el metodo showInputDialog para indicarle al usuario que introduzca la altura.
		//Como la altura introducida es de tipo String, la pasamos a integer mediante el metodo parseInt de la
		//clase Integer. Guardamos el dato en la variable altura, de tipo entero.
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce altura en cm"));
		//Definimos e inicializamos la variable peso ideal.
		int pesoideal = 0;
		// Si el genero es H hacemos una cosa y si es mujer hacemos otra.
		if(genero.equalsIgnoreCase("H")) {
			pesoideal=altura-110;
		}
		
		else if(genero.equalsIgnoreCase("M")) {
			pesoideal=altura-120;
		}
		// Imprimimos en pantalla.
		System.out.println("Tu peso ideal es " + pesoideal);
		
	}

}
