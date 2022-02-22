package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("test")
public class ServicioMock implements Servicio{
	
	private String name;
	
	public ServicioMock() {
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		System.out.println("Soy de mentira");
	}
	
	public void setName(String value) {
		name = value;
	}

}
