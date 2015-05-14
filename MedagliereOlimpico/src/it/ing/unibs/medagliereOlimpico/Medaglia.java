package it.ing.unibs.medagliereOlimpico;

/**
 * Enum Medaglia nella quale vengono definiti i set
 * di valori assumibili dalla enumerazione.
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */
public enum Medaglia {
	ORO("Oro"), ARGENTO("Argento"), BRONZO("Bronzo");

	private final String nome;

	/**
	 * Costruttore privato per rendere i set di
	 * valori delle enum più leggibili
	 * 
	 * @param nome
	 *        Il nome da asseganre ad ogni 
	 *        elemento dell'enum
	 */
	private Medaglia(String nome) {
		this.nome = nome;
	}
	
	//In queso modo quando stampo una medaglia invece di visualizzare ORO 
	//viene visualizzato "Oro"
	@Override
	public String toString() {
		return this.nome;
	}
}
