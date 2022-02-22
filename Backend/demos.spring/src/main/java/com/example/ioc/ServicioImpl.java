package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("despliegue")
public class ServicioImpl implements Servicio {

	private Dependencia dependencia;
	private String name;
	
	public ServicioImpl(Dependencia dep) {
//		dependencia = dep;
		name = dep.getName();	
		}

	@Override
	public void run() {
		//System.out.println("Soy el servicio de " + dependencia.getName());
		System.out.println("Soy el servicio de " + name);
	}
	
	public void setName(String value) {
		name = value;
	}

}
