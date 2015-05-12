package it.ing.unibs.medagliere;

import static org.junit.Assert.*;

/**
 * Classe di test junit relativa alla classe Nazione
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

import org.junit.Test;

public class NazioneTest {

	private final static String NAZIONE = "Italia";

	@Test
	public void getNome() throws Exception {
		Nazione n = new Nazione(NAZIONE);

		assertEquals(NAZIONE, n.getNome());
	}

	@Test
	public void aggiungiMedaglia() throws Exception {
		Nazione n = new Nazione(NAZIONE);
		try {
			n.aggiungiMedaglia(4);
		} catch (IndexOutOfBoundsException e) {
			assertEquals("Valore inserito non valido!", e.getMessage());
		}

	}
	
	@Test
	public void myToString() throws Exception {
		Nazione n = new Nazione(NAZIONE);
		assertEquals("ITALIA -> ORO 0, ARGENTO 0, BRONZO 0", n.toString());

	}
}
