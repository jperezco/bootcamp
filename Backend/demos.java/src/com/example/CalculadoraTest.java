package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraTest {
	Calculadora calc;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calc = new Calculadora(0); // ANTES DE CADA METODO DE PRUEBA
									// CREA UN OBJETO.
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	// Los test de los métodos de la clase Calculadora.
	@Test
	void testGetCurrent() {
		String rslt = null;

		// ...
		rslt = "kk123";
		assertNotNull(rslt);
		assertEquals(5, rslt.length());
		assertTrue(true, "Asercion");

	}

	@Test
	void testCalculadora() {
		fail("Not yet implemented");
	}

	@Nested
	class Suma {
		@Nested
		class OK {
			@Test
			void testSuma_Dos_Positivos() {
				var rlst = calc.suma(1, 2);

				assertEquals(4, rlst);
				assertEquals(4, calc.suma(1, 2));
			}

			@Test
			@DisplayName("Suma dos numeros reales")
			void testSumaDoubleDouble() {
				assertEquals(0.11, Calculadora.suma(1, -0.9), 7);
			}

			@ParameterizedTest(name = "(displayName) -> {0} + {1} = {2}")
			@CsvSource(value = { "2,2,4", "-1,3,2", "0,0,0", "-1,-1,-2" })
			void Validas(double operando1, double operando2, double resultado) {
				assertEquals(resultado, Calculadora.suma(operando1, operando2));
			}

			@Test
			void testSumaDoubleDouble2() {
				assertEquals(0.11, Calculadora.suma(1, -0.9), 7);
			}
		}

	}

	@Nested
	class KO {
		@Test
		@Tag("Smoke")
		void testSumaIntInt() {
			fail("Not yet implemented");
		}

		@Test
		void testSumaDoubleDouble() {
			fail("Not yet implemented");
		}

	}

	@Test
	void testAvg() {
		fail("Not yet implemented");
	}

	@Test
	void testDivideEnteros() {
		assertEquals(2, Calculadora.divideEnteros(4, 2));
		assertEquals(1, Calculadora.divideEnteros(1, 1));
		assertEquals(-2, Calculadora.divideEnteros(4, -2));
		assertEquals(-1, Calculadora.divideEnteros(1, -1));
		assertEquals(0, Calculadora.divideEnteros(1, 0));
	}

	@Test
	void testDivideDecimales() {
		assertThrows(ArithmeticalException.class, () -> Calculadora.divideDecimales(3.0, 0.0));
		assertEquals(Double.POSITIVE_INFINITY, Calculadora.divideDecimales(1, 0));
	}

}
