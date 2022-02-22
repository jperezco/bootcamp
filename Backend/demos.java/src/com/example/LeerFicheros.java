package com.example;

import java.io.*;

public class LeerFicheros {

	public static void main(String[] args) throws Exception {

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
			
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
				
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
		
		
		
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Eclipse\\Salida.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println("-------------");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}

}
