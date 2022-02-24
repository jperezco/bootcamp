package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domains.contracts.ActorRepository;
import com.example.ioc.Servicio;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//Autowired hace que se instancie la clase que implementa el interface.
	@Autowired
	@Qualifier("despliegue")
	Servicio srv;
	
	@Autowired(required = false)
	@Qualifier("manual")
	Servicio srv1;
	
	@Autowired
	ActorRepository dao;
	
	@Override
	public void run(String... args) throws Exception {
//		srv.run();
//		if( srv1 != null) srv1.run();
//		srv.setName("coña");
//		srv1.setName("coña");
//		srv.run();
//		if( srv1 != null) srv1.run();
		dao.findAll().forEach(System.out::println);
		dao.findByFirstNameStartingWithAndLastNameEndingWith("n", "s");
	}


}
