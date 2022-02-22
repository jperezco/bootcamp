package Ajedrez;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableroTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDamePiezaIntInt() throws Exception{
		Tablero tablero = new Tablero();
		assertThrows(Exception.class ,() -> tablero.damePieza(0,1));
		assertThrows(Exception.class ,() -> tablero.damePieza(1,9));
		assertThrows(Exception.class ,() -> tablero.damePieza(2,5));
		Torre torre = new Torre(Color.BLANCO);
		tablero.ponPieza(torre, 1, 1);
		assertEquals(torre, tablero.damePieza(1, 1));
	}

	@Test
	void testDamePiezaPosicion() {
		Tablero tablero = new Tablero();
		assertThrows(Exception.class ,() -> tablero.damePieza(0,1));
		fail("Not yet implemented");
	}

	@Test
	void testPonPiezaPiezaIntInt() {
		fail("Not yet implemented");
	}

	@Test
	void testPonPiezaPiezaPosicion() {
		fail("Not yet implemented");
	}

	@Test
	void testHayPiezaIntInt() throws Exception{
		Tablero tablero = new Tablero();
		Torre torre = new Torre(Color.BLANCO);
		tablero.ponPieza(torre, 1, 1);
		assertTrue(tablero.hayPieza(1, 1));
	}

	@Test
	void testHayPiezaPosicion() {
		fail("Not yet implemented");
	}

	@Test
	void testQuitaPiezaIntInt() {
		fail("Not yet implemented");
	}

	@Test
	void testQuitaPiezaPosicion() {
		fail("Not yet implemented");
	}

	@Test
	void testMover() {
		fail("Not yet implemented");
	}

	@Test
	void testClone() {
		fail("Not yet implemented");
	}

	@Test
	void testColorEscaque() {
		fail("Not yet implemented");
	}

	@Test
	void testHayPiezasEntre() {
		fail("Not yet implemented");
	}

}
