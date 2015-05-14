package it.ing.unibs.medagliereOlimpico;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe di test junit relativa alla classe Gara
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */
public class GaraTest {

	private final static String GARA = "Salto in alto";
	@Test
	public void getNome() throws Exception {
		Gara g = new Gara(GARA);
		assertEquals(GARA, g.getNome());
	}
	
	@Test
	public void myToString() throws Exception {
		Gara g = new Gara(GARA);
		assertEquals(GARA, g.toString());
	}

}
