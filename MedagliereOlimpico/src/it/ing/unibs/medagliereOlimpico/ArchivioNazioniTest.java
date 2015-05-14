package it.ing.unibs.medagliereOlimpico;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Classe di test junit relativa alla classe ArchivioNazioni
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

public class ArchivioNazioniTest {

	private final static String NAZIONE_1 = "Italia";
	private final static String NAZIONE_2 = "Francia";

	@Test
	public void aggiungiNazione() throws Exception {
		ArchivioNazioni a = new ArchivioNazioni();
		Nazione n = new Nazione(NAZIONE_1);
		a.aggiungiNazione(n);
		assertEquals(n, a.getNazione(NAZIONE_1));

		// Se provo ad aggiungere la stessa
		// nazione dovrebbe darmi errore
		try {
			a.aggiungiNazione(new Nazione(NAZIONE_1));
		} catch (IllegalArgumentException e) {
			assertEquals("La nazione che stai cercando di aggiungere e' gia' presente!", e.getMessage());
		}

		// Se provo ad aggiungere null dovrebbe darmi un errore
		try {
			a.aggiungiNazione(null);
		} catch (IllegalArgumentException e) {
			assertEquals("La nazione che stai cercando di aggiungere deve esistere!", e.getMessage());
		}
	}

	@Test
	public void contieneNazione() throws Exception {
		Nazione n = new Nazione(NAZIONE_1);
		ArchivioNazioni a = new ArchivioNazioni();
		a.aggiungiNazione(n);

		// Il controllo all'interno della classe è effettuato
		// utilizzando equalsIgnoreCase, verifico se ritorna
		// comunque true
		assertTrue(a.contieneNazione(NAZIONE_1.toUpperCase()));
		assertFalse(a.contieneNazione(NAZIONE_2));
	}

	@Test
	public void getNazione() throws Exception {
		Nazione n = new Nazione(NAZIONE_1);
		ArchivioNazioni a = new ArchivioNazioni();
		a.aggiungiNazione(n);		
		assertEquals(n, a.getNazione(NAZIONE_1));
		
		// Verifico che se la nazione
		// non è presente è lanciata un'eccezione
		try {
			a.getNazione(NAZIONE_2);
		} catch (NullPointerException e) {
			assertEquals("La nazione cercata non fa parte dell'archivio!", e.getMessage());
		}		

	}

}
