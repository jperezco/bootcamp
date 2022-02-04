package capgemini;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class JuegoDelNumeroTest {

	JuegoDelNumero juego;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		juego = new JuegoDelNumero();
		juego.numeroBuscado = 50;
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testJuegoDelNumero() {
		assertNotNull(juego);
	}

	@Test
	void testInicializar() {
		juego.numeroBuscado = -1;
		juego.inicializar();
		assertAll("Inicializar", () -> assertEquals("Pendientes de empezar", juego.getResultado()),
				() -> assertEquals(0, juego.getJugada()),
				() -> assertTrue(0 < juego.numeroBuscado && juego.numeroBuscado <= 100, "rango entre 1 y 100"));
	}

	@Nested
	class jugadas {
		@Test
		void test_es_mayor() throws JuegoException {
			juego.jugada(51);
			assertAll("Jugada", () -> assertEquals("Mi número es menor.", juego.getResultado()),
					() -> assertEquals(1, juego.getJugada()));
		}

		@Test
		void test_es_menor() throws JuegoException {
			juego.jugada(49);
			assertAll("Jugada", () -> assertEquals("Mi número es mayor.", juego.getResultado()),
					() -> assertEquals(1, juego.getJugada()));
		}

		@Test
		void test_es_igual() throws JuegoException {
			juego.jugada(50);
			assertAll("Jugada", () -> assertEquals("Bieeen!!! Acertaste.", juego.getResultado()),
					() -> assertEquals(1, juego.getJugada()));
		}

		@Test
		void test_sin_intentos() throws JuegoException {
			for (int i = 1; i <= 10; i++) {
				juego.jugada(juego.numeroBuscado + 1);
			}
			assertEquals("Upsss! Se acabaron los intentos, el número era el " + juego.numeroBuscado,
					juego.getResultado());
		}
		
		@Test
		void testFinalizadoException() throws JuegoException{
			juego.jugada(50);
			//SI INTENTAS JUGAR UNA VEZ HAS ACERTADO: EXCEPTION.
			assertThrows(JuegoException.class, () -> juego.jugada(50));
		}
		
	}

	@Nested
	class jugadasString {
		@Test
		void testStringConNumero() throws JuegoException {
			juego.jugada("51");
			assertAll("Jugada", () -> assertEquals("Mi número es menor.", juego.getResultado()),
					() -> assertEquals(1, juego.getJugada()));
		}

		@Test
		void testStringSinNumero() throws JuegoException {
			assertThrows(JuegoException.class, () -> juego.jugada("Cincuenta"));
		}
	}

	@Test
	void testGetResultado() {
		fail("Not yet implemented");
	}

	@Nested
	class Finalizados {

		@Test
		void testNoEncontrado() throws JuegoException {
			for (int i = 1; i <= 9; i++) {
				juego.jugada(51);
			}
			assertEquals(false, juego.getFinalizado());

		}

		@Test
		void testEncontrado() throws JuegoException {
			for (int i = 1; i <= 9; i++) {
				juego.jugada(51);
			}
			juego.jugada(50);
			assertEquals(true, juego.getFinalizado());

		}

		@Test
		void testSinIntentos() throws JuegoException {
			for (int i = 1; i <= 10; i++) {
				juego.jugada(juego.numeroBuscado + 1);
			}

			assertEquals(true, juego.getFinalizado());

		}
	}

	@Test
	void testGetJugada() throws JuegoException {
		for (int i = 1; i <= 5; i++) {
			juego.jugada(51);
		}

		assertEquals(5, juego.getJugada());
	}

}
