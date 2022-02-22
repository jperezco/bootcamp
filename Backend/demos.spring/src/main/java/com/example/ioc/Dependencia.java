package com.example.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dependencia {
	
	//Le estamos diciendo que lea el archivo de configuracion y saque el valor de ahí.
	@Value("${mi.config.name}")
	private String nombre;
	public Dependencia() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return nombre;
	}

}
