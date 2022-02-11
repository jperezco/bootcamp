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
		
		Movimiento movimiento = new Movimiento("a3H8");
		
		assertEquals(3,movimiento.posicionInicial().fila());
		assertEquals(1,movimiento.posicionInicial().columna());
		assertEquals(8,movimiento.posicionFinal().fila());
		assertEquals(8,movimiento.posicionFinal().columna());
		
		assertThrows(Exception.class ,() -> new Movimiento("c5C5"));		
	}

	@Test
	void testPosicionInicial() throws Exception{
		Movimiento movimiento = new Movimiento("c7a2");
		assertEquals(7,movimiento.posicionInicial().fila());
		assertEquals(3,movimiento.posicionInicial().columna());
	}

	@Test
	void testPosicionFinal() throws Exception{
		Movimiento movimiento = new Movimiento("c7a2");
		assertEquals(2,movimiento.posicionFinal().fila());
		assertEquals(1,movimiento.posicionFinal().columna());
	}

	@Test
	void testEsVertical() throws Exception{
		Movimiento movimiento = new Movimiento("c7c2");
		assertTrue(movimiento.esVertical());
		Movimiento movimiento2 = new Movimiento("c7b7");
		assertFalse(movimiento2.esVertical());
	}

	@Test
	void testEsHorizontal() throws Exception{
		Movimiento movimiento = new Movimiento("d7a7");
		assertTrue(movimiento.esHorizontal());
		Movimiento movimiento2 = new Movimiento("a2H3");
		assertFalse(movimiento2.esHorizontal());
	}

	@Test
	void testSaltoHorizontal() throws Exception{
		Movimiento movimiento = new Movimiento("G7a2");
		assertEquals(-6, movimiento.saltoHorizontal());
		Movimiento movimiento2 = new Movimiento("G7g2");
		assertEquals(0, movimiento2.saltoHorizontal());
		Movimiento movimiento3 = new Movimiento("G7h2");
		assertEquals(1, movimiento3.saltoHorizontal());
	}

	@Test
	void testSaltoVertical() throws Exception{
		Movimiento movimiento = new Movimiento("G7a2");
		assertEquals(-5, movimiento.saltoVertical());
		Movimiento movimiento2 = new Movimiento("c3d3");
		assertEquals(0, movimiento2.saltoVertical());
		Movimiento movimiento3 = new Movimiento("c5D6");
		assertEquals(1, movimiento3.saltoVertical());
	}

	@Test
	void testEsDiagonal() throws Exception{
		Movimiento movimiento = new Movimiento("A1e5");
		assertTrue(movimiento.esDiagonal());
		Movimiento movimiento2 = new Movimiento("b8A7");
		assertTrue(movimiento2.esDiagonal());
	}

	@Test
	void testDeltaFila() throws Exception{
		Movimiento movimiento = new Movimiento("A1e5");
		assertEquals(1, movimiento.deltaFila());
		Movimiento movimiento2 = new Movimiento("F6E8");
		assertEquals(-1, movimiento2.deltaFila());
		Movimiento movimiento3 = new Movimiento("C4C5");
		assertEquals(0, movimiento3.deltaFila());
	}

	@Test
	void testDeltaColumna() throws Exception{
		Movimiento movimiento = new Movimiento("A1e5");
		assertEquals(1, movimiento.deltaColumna());
		Movimiento movimiento2 = new Movimiento("F6E2");
		assertEquals(-1, movimiento2.deltaColumna());
		Movimiento movimiento3 = new Movimiento("B4h4");
		assertEquals(0, movimiento3.deltaColumna());
	}

}
