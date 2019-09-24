package application;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class RechnungenTests {

	@Test
	void testAlterAuto() {
		int erg = Rechnen.alterAuto(2011, 2019);
		assertTrue(erg==8);
	}

	@Test
	void testwertVerlustNachZeit() {
		int erg = (int)Rechnen.wertVerlustNachKM(8, 42000);
		assertTrue(erg==18079);
	}
	
	
}
