package Ajedrez;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PosicionTest {

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
	void testPosicionIntInt() throws Exception{
		Posicion posicion = new Posicion(1,8);
		assertEquals(1, posicion.fila());
		assertEquals(8, posicion.columna());
		assertThrows(Exception.class, () -> new Posicion(0,8));
		assertThrows(Exception.class, () -> new Posicion(1,9));
	}

	@Test
	void testPosicionCharChar() throws Exception{
		Posicion posicion = new Posicion('1','h');
		assertEquals(1, posicion.fila());
		assertEquals(8, posicion.columna());
		assertThrows(Exception.class, () -> new Posicion('0','H'));
		assertThrows(Exception.class, () -> new Posicion('1','i'));
	}

	@Test
	void testFila() throws Exception{
		Posicion posicion = new Posicion(1,8);
		assertEquals(1, posicion.fila());
		Posicion posicion2 = new Posicion('8','b');
		assertEquals(8, posicion2.fila());
	}

	@Test
	void testColumna() throws Exception{
		Posicion posicion = new Posicion(1,8);
		assertEquals(8, posicion.columna());
		Posicion posicion2 = new Posicion('8','a');
		assertEquals(1, posicion2.columna());
	}

	@Test
	void testEqualsPosicion() throws Exception{
		Posicion posicion = new Posicion(1,8);
		Posicion posicion2 = new Posicion('1','h');
		assertTrue(posicion.equals(posicion2));
		Posicion posicion3 = new Posicion(3,3);
		Posicion posicion4 = new Posicion('3','a');
		assertFalse(posicion3.equals(posicion4));
	}

}
