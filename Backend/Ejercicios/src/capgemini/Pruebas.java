package capgemini;

public class Pruebas {

	public static void main(String[] args) throws Exception {
		BarajaFrancesa barajaFrancesa = new BarajaFrancesa();
		System.out.println("Esta es la baraja francesa ordenada");
		System.out.println(barajaFrancesa.enseñaBarajaFrancesa());
		barajaFrancesa.barajarBarajaFrancesa();
		System.out.println("Esta es la baraja francesa desordenada");
		System.out.println(barajaFrancesa.enseñaBarajaFrancesa());
	}

}
