package it.ing.unibs.medagliere;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe di test junit relativa alla classe ArchivioGare
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

public class ArchivioGareTest {

	private final static String GARA_1 = "Salto in alto";
	private final static String GARA_2 = "Salto in lungo";

	private ArchivioGare creaArchivio(String... gare) {
		ArchivioGare archivio = new ArchivioGare();
		for (String g : gare)
			archivio.aggiungiGara(new Gara(g));

		return archivio;

	}

	@Test
	public void aggiungiGara() throws Exception {
		ArchivioGare a = creaArchivio(GARA_1);
		assertEquals(1, a.getNumeroGare());

		// Se provo ad aggiungere la stessa
		// gara dovrebbe darmi errore

		try {
			a.aggiungiGara(new Gara(GARA_1));
		} catch (IllegalArgumentException e) {
			assertEquals(
					"Il nome della gara che si sta provando ad inserire è già presente nell' elenco!",
					e.getMessage());
		}

		// Se provo ad aggiungere null dovrebbe darmi un errore

		try {
			a.aggiungiGara(null);
		} catch (IllegalArgumentException e) {
			assertEquals("L'argomento non può essere null!", e.getMessage());
		}
	}

	@Test
	public void garaPresente() throws Exception {
		ArchivioGare a = creaArchivio(GARA_1);

		// Il controllo all'interno della classe è effettuato
		// utilizzando equalsIgnoreCase, verifico se ritorna
		// comunque true
		assertTrue(a.garaPresente(GARA_1.toUpperCase()));
		assertFalse(a.garaPresente(GARA_2));
	}

	@Test
	public void getNumeroGare() throws Exception {
		ArchivioGare a = new ArchivioGare();
		assertEquals(0, a.getNumeroGare());

		ArchivioGare a1 = creaArchivio(GARA_1, GARA_2);
		assertEquals(2, a1.getNumeroGare());

	}

}
