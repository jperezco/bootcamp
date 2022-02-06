package capgemini;

public class Bombilla {
	
	private boolean estado;
	private int potencia;
	private String color;
	private double horas;
	
	public Bombilla() {
		estado = false;
		horas = 10.0;
	}
	
	public String encender(double horas) {
		if (this.horas >= horas) {
			estado =  true;
			this.horas -= horas;
			return "";
		}else {return "No puedes tenerla tanto tiempo encendida. Solo "
				+ "quedan " + this.horas + " horas";}	
	}
	
	public String verHoras() {
		return "La bombilla se va a apagar dentro de " + horas + " horas";
	}
	
	public void apagar() {
		estado = false;
	}
	
	public String verEstado() {
		if (estado) {
			return "La bombilla está encendida";
		}else {return "La bombilla está apagada";}
		
	}
	
	public void cambiaPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	public int verPotencia() {
		return potencia;
	}
	
	public void cambiaColor(String color) {
		if (estado) {
			estado = false;
			this.color = color;
		}else {this.color = color;}
	}
	
	public String verColor() {
		return "La bombilla es de color " + color;
	}
	
	public void recargar(double horas) {
		this.horas += horas;
	}
	
}
