package poo;

import java.util.*;

public class Uso_Empleado {
	public static void main(String[] args) {
				
		Empleado[] misEmpleados = new Empleado[4];
		
		misEmpleados[0] = new Empleado("Paco Gómez", 85000, 1990, 12, 17);
		misEmpleados[1] = new Empleado("Ana López", 95000, 1995, 06, 02);
		misEmpleados[2] = new Empleado("María Martín", 105000, 2002, 03, 15);
		misEmpleados[3] = new Empleado("Antonio Fernández");
				
		for (Empleado e: misEmpleados) {
			e.subeSueldo(5);
		}
				
		for (Empleado e: misEmpleados) {
			System.out.println("Nombre: " + e.dameNombre() + 
					" Sueldo: " + e.dameSueldo()
					+ " Fecha de Alta: " + e.dameFechaContrato());
		}	
	}
}



class Empleado {
	
	public Empleado(String nom, double sue, int agno, int mes, int dia) {//CONSTRUCTOR 1º		
		nombre = nom;
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);
		altaContrato = calendario.getTime();	
	}
	
	public Empleado(String nom) {//CONSTRUCTOR 2º. SOBRECARGA DE CONSTRUCTORES
		this(nom, 30000, 2000, 01, 01); //LLAMA AL OTRO CONSTRUCTOR Y CREA EL OBJETO CON
		                                //LOS DATOS CORRESPONDIENTES.
	}
	
	public String dameNombre() { //Getter	
		return nombre;	
	}
	
	public double dameSueldo() { //Getter
		return sueldo;
	}
	
	public Date dameFechaContrato() { //Getter
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje) { //Setter
		double aumento = sueldo*porcentaje/100;
		sueldo += aumento;
	}
	
	private String nombre;	
	private double sueldo;	
	private Date altaContrato;
}



class Jefatura extends Empleado{
	
	public Jefatura(String nom, double sue, int agno, int mes, int dia) {
		super(nom, sue, agno, mes, dia);
	}
	
	public void estableceIncentivo(double b) {
		incentivo = b;
	}
	
	public double dameSueldo() {
		double sueldoJefe = super.dameSueldo(); //LLAMAMOS AL METODO DEL PADRE
		                                        //Y ALMACENAMOS LO QUE DEVUELVE
		return sueldoJefe + incentivo;
	}
	private double incentivo;
}
