package capgemini;

public class Pruebas {

	public static void main(String[] args) throws Exception {
		BarajaFrancesa barajaFrancesa = new BarajaFrancesa();
		barajaFrancesa.quitarCartasBarajaFrancesa(10);
		System.out.println("Esta es la baraja con las cartas quitadas");
		System.out.println(barajaFrancesa.ense�aBarajaFrancesa());
		System.out.println("Estas son las cartas repartidas");
		System.out.println(barajaFrancesa.ense�aLasCartasRepartidas());
		barajaFrancesa.juntaBaraja();
		System.out.println(barajaFrancesa.ense�aBarajaFrancesa());
		System.out.println(barajaFrancesa.ense�aLasCartasRepartidas());		
	}

}
