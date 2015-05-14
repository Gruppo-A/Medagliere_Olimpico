package it.ing.unibs.medagliereOlimpico;

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

	@Test
	public void aggiungiGara() throws Exception {
		ArchivioGare a = new ArchivioGare();
		Gara g = new Gara(GARA_1);
		a.aggiungiGara(g);
		assertEquals(g, a.getGara(GARA_1));

		// Se provo ad aggiungere la stessa
		// gara dovrebbe darmi errore
		try {
			a.aggiungiGara(new Gara(GARA_1));
		} catch (IllegalArgumentException e) {
			assertEquals("La gara che stai cercando di aggiungere e' gia' presente!", e.getMessage());
		}

		// Se provo ad aggiungere null dovrebbe darmi un errore
		try {
			a.aggiungiGara(null);
		} catch (IllegalArgumentException e) {
			assertEquals("La gara che stai cercando di aggiungere deve esistere!", e.getMessage());
		}
	}

	@Test
	public void contieneGara() throws Exception {
		Gara g = new Gara(GARA_1);
		ArchivioGare a = new ArchivioGare();
		a.aggiungiGara(g);

		// Il controllo all'interno della classe è effettuato
		// utilizzando equalsIgnoreCase, verifico se ritorna
		// comunque true
		assertTrue(a.contieneGara(GARA_1.toUpperCase()));
		assertFalse(a.contieneGara(GARA_2));
	}

	@Test
	public void getGara() throws Exception {
		Gara g = new Gara(GARA_1);
		ArchivioGare a = new ArchivioGare();
		a.aggiungiGara(g);
		assertEquals(g, a.getGara(GARA_1));
		
		// Verifico che se la gara
		// non è presente è lanciata un'eccezione
		try {
			a.getGara(GARA_2);
		} catch (NullPointerException e) {
			assertEquals("La gara cercata non fa parte dell'archivio!", e.getMessage());
		}		

	}

}
