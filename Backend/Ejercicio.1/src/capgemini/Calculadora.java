package capgemini;

public class Calculadora {
	
	//private String cadena = "";
	//private char cadena_div[];
    
	public double calcular(String cadena) {
		//this.cadena = cadena;
		char cadena_div[] = cadena.toCharArray();
		double b = 0.0;
		String num = "";
		
		for(int i=0; i < cadena_div.length; i++) {
			if (Character.isDigit(cadena_div[i]) || 
					cadena_div[i] == '.') {
				
				num += cadena_div[i];
				
			}
			
            if (cadena_div[i] == '+') {
            	double a = Double.parseDouble(num);
            	b += a;
            	num = "";
            }
            
            if (cadena_div[i] == '-') {
            	double a = Double.parseDouble(num);
            	b -= a;
            	num = "";
            }
            
            if (cadena_div[i] == '/') {
            	double a = Double.parseDouble(num);
            	b /= a;
            	num = "";
            }
            
            if (cadena_div[i] == '*') {
            	double a = Double.parseDouble(num);
            	b *= a;
            	num = "";
            }
               
		}
		
		return b;
	}

}
