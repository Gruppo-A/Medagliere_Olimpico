package it.ing.unibs.medagliereOlimpico;

import java.util.EnumMap;

/**
 * Classe Nazione nella quale vengono definite le azioni che si possono compiere
 * con una nazione e le sue caratteristiche.
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */
public class Nazione {

	private String nome;
	private EnumMap<Medaglia, Integer> listaMedaglie;
	private final static int VALORE_STANDARD = 1;

	/**
	 * Costruttore per la creazione di una nazione utilizzando il nome dello
	 * nazione
	 * 
	 * @param nome
	 *            il nome della nazione
	 */
	public Nazione(String nome) {
		this.nome = nome;
		listaMedaglie = new EnumMap<>(Medaglia.class);
	}

	/**
	 * Getter dell'attributo nome
	 * 
	 * @return il nome della nazione
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Permette di aggiungere una medaglia alla nazione 
	 * e ne aumenta il conteggio per tipo
	 * 
	 * @param medaglia
	 *        la medaglia da inserire (oro, argento o bronzo)
	 */
	public void aggiungiMedaglia(Medaglia medaglia) {
		// Se per la medaglia non è mai stato inserito un valore, il valore
		// iniziale e' quello standard (1)
		int ultimoValore = VALORE_STANDARD;
		
		// Se per la medaglia sono gia' stati inseriti dei valori, recupero
		// l'ultimo valore e lo aumentato dell'unita'
		if (listaMedaglie.containsKey(medaglia)) {
			ultimoValore = listaMedaglie.get(medaglia).intValue();
			ultimoValore++;			
		}
		
		// Inserisco per il tipo di medaglia il suo valore
		listaMedaglie.put(medaglia, ultimoValore);
	}

	@Override
	public String toString() {
		StringBuilder descrizione = new StringBuilder(nome + " -> ");
		descrizione.append(listaMedaglie);

		// I replaceAll vengono utilizzati per modificare
		// la visualizzazione standard delle EnumMap che non viene
		// ritenuta gradevole da un punto di vista estestico.
		// Si passa da nomeNazione -> {nomeMedaglia=1}
		// a nomeNazione -> nomeMedaglia: 1
		return descrizione.toString().replaceAll("[{}]","").replaceAll("=",": ");
	}
}
