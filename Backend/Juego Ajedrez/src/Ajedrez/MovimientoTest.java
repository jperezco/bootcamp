package Ajedrez;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovimientoTest {

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
	void testMovimiento() throws Exception{
		assertThrows(Exception.class ,() -> new Movimiento("a3b45"));
		assertThrows(Exception.class ,() -> new Movimiento(""));
		assertThrows(Exception.class ,() -> new Movimiento("a3b"));
		assertThrows(Exception.class ,() -> new Movimiento(null));
	}

	@Test
	void testPosicionInicial() {
		fail("Not yet implemented");
	}

	@Test
	void testPosicionFinal() {
		fail("Not yet implemented");
	}

	@Test
	void testEsVertical() {
		fail("Not yet implemented");
	}

	@Test
	void testEsHorizontal() {
		fail("Not yet implemented");
	}

	@Test
	void testSaltoVertical() {
		fail("Not yet implemented");
	}

	@Test
	void testSaltoHorizontal() {
		fail("Not yet implemented");
	}

	@Test
	void testEsDiagonal() {
		fail("Not yet implemented");
	}

	@Test
	void testDeltaFila() {
		fail("Not yet implemented");
	}

	@Test
	void testDeltaColumna() {
		fail("Not yet implemented");
	}

}
