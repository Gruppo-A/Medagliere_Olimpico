package it.ing.unibs.medagliere;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe di test junit relativa alla classe Gara
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

public class GaraTest {

	@Test
	public void getNome() throws Exception {
		Gara g = new Gara("Salto in alto");
		assertEquals("Salto in alto", g.getNome());
	}

}
