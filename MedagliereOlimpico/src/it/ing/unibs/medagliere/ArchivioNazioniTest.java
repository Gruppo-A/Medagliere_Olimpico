package it.ing.unibs.medagliere;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe di test junit relativa alla classe ArchivioNazioni
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

public class ArchivioNazioniTest {
	
	private static final String NAZIONE_1 = "Italia";
	private static final String NAZIONE_2 = "Francia";
	
	private ArchivioNazioni creaArchivio(String... nazioni)
	{
		ArchivioNazioni archivio = new ArchivioNazioni();
		for(String n : nazioni)
			archivio.aggiungiNazione(new Nazione(n));
		
		return archivio;
		
	}

	@Test
	public void aggiungiNazione() throws Exception {
		ArchivioNazioni a = creaArchivio(NAZIONE_1);
		assertEquals(1, a.getNumeroNazioni());

		// Se provo ad aggiungere la stessa
		// Nazione dovrebbe darmi errore

		try {
			a.aggiungiNazione(new Nazione(NAZIONE_1));
		} catch (IllegalArgumentException e) {
			assertEquals("Il nome della nazione che si sta provando ad inserire è già presente nell' elenco!", e.getMessage());
		}
		
		// Se provo ad aggiungere null dovrebbe darmi un errore
		
		try {
			a.aggiungiNazione(null);
		} catch (IllegalArgumentException e) {
			assertEquals("L'argomento non può essere null!", e.getMessage());
		}
	}
	
	@Test
	public void NazionePresente() throws Exception {
		ArchivioNazioni a = creaArchivio(NAZIONE_1);
		
		// Il controllo all'interno della classe è effettuato
		// utilizzando equalsIgnoreCase, , verifico se ritorna
		// comunque true
		assertTrue(a.nazionePresente(NAZIONE_1.toUpperCase()));		
		assertFalse(a.nazionePresente(NAZIONE_2));
	}
	
	@Test
	public void getNumeroNazioni() throws Exception {
		ArchivioNazioni a = new ArchivioNazioni();		
		assertEquals(0, a.getNumeroNazioni());		
		
		ArchivioNazioni a1 = creaArchivio(NAZIONE_1, NAZIONE_2);
		assertEquals(2, a1.getNumeroNazioni());
		
	}
}