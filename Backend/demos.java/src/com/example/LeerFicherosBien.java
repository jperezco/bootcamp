package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeerFicherosBien {
	
	String linea;
	
	public String leeFichero(File cadena, FileReader fr, BufferedReader br) {

		cadena = null;
		fr = null;
		br = null;

		try {
			cadena = new File("C:\\Eclipse\\Cadena.txt");
			fr = new FileReader(cadena);
			br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {
				Calculadora.decode(linea);
				System.out.println(linea);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return linea;
	}

}
