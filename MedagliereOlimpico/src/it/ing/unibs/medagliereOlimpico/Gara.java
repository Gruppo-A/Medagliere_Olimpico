package it.ing.unibs.medagliereOlimpico;

/**
 * Classe Gara nella quale vengono definite le azioni che si possono compiere
 * con una gara e le sue caratteristiche.
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

public class Gara {

	private String nome;

	/**
	 * Costruttore per la creazione di una gara utilizzando il suo nome
	 * 
	 * @param nome
	 *            il nome della gara
	 */
	public Gara(String nome) {
		this.nome = nome;
	}

	/**
	 * Getter dell'attributo nome
	 * 
	 * @return il nome della gara
	 */
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return nome;
	}
}
