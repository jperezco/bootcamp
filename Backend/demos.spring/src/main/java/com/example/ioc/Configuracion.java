package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Para que Spring mire esta clase, en caso de que necesite instanciarla.
@Configuration
public class Configuracion {
	
	// Para que Spring mire este método.
	@Bean
	@Qualifier("manual")
	public Servicio miServicio(Dependencia dep) {
		System.out.println("Creando el servicio de " + dep.getName());
		return new ServicioMock();
	}
}
