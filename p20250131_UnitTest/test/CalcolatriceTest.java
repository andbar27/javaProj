import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalcolatriceTest {

	@Test
	void testSomma() {
		Calcolatrice c = new Calcolatrice();
		assertEquals(2, c.somma(1, 1));
	}

	@Test
	void testSottrazione() {
		Calcolatrice c = new Calcolatrice();
		assertEquals(0, c.sottrazione(1, 1));
	}

	@Test
	void testDivisione() {
		Calcolatrice c = new Calcolatrice();
		assertEquals(1, c.divisione(1, 1));
	}

	@Test
	void testMoltiplicazione() {
		Calcolatrice c = new Calcolatrice();
		assertEquals(1, c.somma(1, 1));
	}

}
