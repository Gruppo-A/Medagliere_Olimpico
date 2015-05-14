package it.ing.unibs.medagliereOlimpico;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe di test junit relativa alla classe Nazione
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */
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
		n.aggiungiMedaglia(Medaglia.ORO);
		n.aggiungiMedaglia(Medaglia.ORO);
		n.aggiungiMedaglia(Medaglia.ORO);
		n.aggiungiMedaglia(Medaglia.ARGENTO);		
		n.aggiungiMedaglia(Medaglia.ARGENTO);
		n.aggiungiMedaglia(Medaglia.BRONZO);
		
		// Mi aspetto 3 Ori, 2 Argenti e 1 Bronzo
		assertEquals("Italia -> Oro: 3, Argento: 2, Bronzo: 1", n.toString());

	}
	
	@Test
	public void myToString() throws Exception {
		Nazione n = new Nazione(NAZIONE);
		
		n.aggiungiMedaglia(Medaglia.ORO);
		assertEquals("Italia -> Oro: 1", n.toString());
		
		n.aggiungiMedaglia(Medaglia.ARGENTO);
		assertEquals("Italia -> Oro: 1, Argento: 1", n.toString());
		
		n.aggiungiMedaglia(Medaglia.BRONZO);
		assertEquals("Italia -> Oro: 1, Argento: 1, Bronzo: 1", n.toString());

	}

}
