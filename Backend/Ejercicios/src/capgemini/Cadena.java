package capgemini;

public class Cadena {
	public static void main(String[] args) {
		//Metemos la cadena a separar.
		String cadena = "3+4+3.4-7*1=";
		//La dividimos en caracteres y la pasamos a una variable char.
		char cadena_div[] = cadena.toCharArray();
		String num = "";
		String operaciones = "";
		
		System.out.println(cadena);

		//La vamos recorriendo. Si es un numero imprimimos sin pasar de linea.
		//Si no lo es imprimimos pasando de línea.
		for(int i=0; i < cadena_div.length; i++) {
			if (Character.isDigit(cadena_div[i]) || 
				cadena_div[i] == '.') {
				num += cadena_div[i];
				operaciones += " ";
			}else {
				num += " ";
				operaciones += cadena_div[i];
			}		
		}
		
		System.out.println(num);
		System.out.println(operaciones);
	}
}
