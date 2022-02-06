package capgemini;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BombillaTest {
    Bombilla b;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		 b = new Bombilla();	
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	

	@Test
	void testBombilla() {		
		assertEquals("La bombilla está apagada", b.verEstado());
		assertEquals("La bombilla se va a apagar dentro de " + 10.0 + " horas", 
				b.verHoras());
	}

	@Test
	void testEncender() {
		
	}

	@Test
	void testVerHoras() throws Exception{
		b.encender(10.0);
		assertEquals("La bombilla se va a apagar dentro de " + 0.0 + " horas", 
				b.verHoras());
		assertThrows(Exception.class, () -> b.recargar(-0.01));
	}

	@Test
	void testApagar() {
		fail("Not yet implemented");
	}

	@Test
	void testVerEstado() {
		fail("Not yet implemented");
	}

	@Test
	void testCambiaPotencia() {
		fail("Not yet implemented");
	}

	@Test
	void testVerPotencia() {
		fail("Not yet implemented");
	}

	@Test
	void testCambiaColor() {
		fail("Not yet implemented");
	}

	@Test
	void testVerColor() {
		fail("Not yet implemented");
	}

	@Test
	void testRecargar() {
		fail("Not yet implemented");
	}

}
