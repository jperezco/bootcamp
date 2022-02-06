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
	
	public String encender(double horas) throws Exception{
		if (horas < 0.0) {
			throw new Exception("Las horas deben ser positivas");
		}
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
	
	public void cambiaPotencia(int potencia) throws Exception {
		if (potencia < 0) {
			throw new Exception ("La potencia no puede ser negativa");
		}
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
	
	public void recargar(double horas) throws Exception {
		if (horas < 0.0) {
			throw new Exception("No puedes recargar horas negativas");
		}
		this.horas += horas;
		
	}
	
}
