package com.example;

public class Factura implements Grafico{
	//VAraible de tipo estado que me creo yo.
	public static enum Estado {PENDIENTE,PASADA,CANCELADA}
	public class Linea{
		private String concepto;
		private int cantidad;
		private double precio;
		public Linea(String concepto, int cantidad, double precio) {
			super();
			this.concepto = concepto;
			setCantidad(cantidad);
			this.precio = precio;
		}
		public String getConcepto() {
			return concepto;
		}
		public void setConcepto(String concepto) {
			this.concepto = concepto;
		}
		public int getCantidad() {
			return cantidad;
		}
		public void setCantidad(int cantidad) {
			if(this.cantidad == cantidad) return;
			if(this.cantidad < 1) throw new IllegalArgumentException("La cab¡ntidad debe ser mayor que 0.");
			this.cantidad = cantidad;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		public double getTotal() {
			return cantidad*precio;
		}
	}
	private int numero;
	private String direccion;
	private Estado estado;
	private Linea() lineas;

}
