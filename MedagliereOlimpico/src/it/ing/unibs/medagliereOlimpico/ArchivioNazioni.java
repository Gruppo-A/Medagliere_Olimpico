package it.ing.unibs.medagliereOlimpico;

import java.util.ArrayList;

/**
 * Classe ArchivioNazioni nella quale vengono definite le azioni che si possono
 * compiere con un archivio di nazioni e le sue caratteristiche.
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

public class ArchivioNazioni {

	ArrayList<Nazione> listaNazioni;

	// Stringhe costanti per le eccezioni
	private final static String ERRORE_NAZIONE_NULL = "La nazione che stai cercando di aggiungere deve esistere!";
	private final static String ERRORE_NAZIONE_DOPPIA = "La nazione che stai cercando di aggiungere e' gia' presente!";
	private final static String ERRORE_NAZIONE_ASSENTE = "La nazione cercata non fa parte dell'archivio!";

	/**
	 * Costruttore di default per la creazione di un arcivio di nazioni
	 */
	public ArchivioNazioni() {
		listaNazioni = new ArrayList<>();
	}

	/**
	 * Permette di aggiungere una nazione all'archivio
	 * 
	 * @param nazione
	 *            la nazione da aggiugnere all'archivio
	 * 
	 * @throws IllegalArgumentException
	 *             - se la nazione è null 
	 *             - se esiste già una nazione con lo
	 *               stesso nome nell'archivio
	 */
	public void aggiungiNazione(Nazione nazione) throws IllegalArgumentException {
		if (nazione == null)
			throw new IllegalArgumentException(ERRORE_NAZIONE_NULL);

		for (Nazione n : listaNazioni) {
			if (nazione.getNome().equals(n.getNome()))
				throw new IllegalArgumentException(ERRORE_NAZIONE_DOPPIA);
		}

		listaNazioni.add(nazione);
	}
    
	/**
	 * Permette di controllare se una nazione è presente 
	 * o meno nell'archivio
	 * 
	 * @param nomeNazione
	 *            il nome della nazione di cui controllare la presenza
	 * 
	 * @return - true se la nazione è presente 
	 *         - false se la nazione non è presente
	 * 
	 */
	public boolean contieneNazione(String nomeNazione) {
		for (Nazione n : listaNazioni) {
			if (n.getNome().equalsIgnoreCase(nomeNazione))
				return true;
		}
		return false;
	}
		
	/**
	 * Permette di ottenre una nazione dell'archivio dal suo nome
	 * 
	 * @param nomeNazione
	 *        il nome della nazione che si vuole ottenere
	 *        
	 * @return la nazione richiesta (se fa parte dell'archivio)
	 * 
	 * @throws NullPointerException
	 *         se la nazione cercata non fa parte dell'archivio
	 */
	public Nazione getNazione(String nomeNazione) throws NullPointerException {
		for (Nazione nazione : listaNazioni)
			if (nazione.getNome().equalsIgnoreCase(nomeNazione))
				return nazione;

		throw new NullPointerException(ERRORE_NAZIONE_ASSENTE);
		
	}

	@Override
	public String toString() {
		StringBuilder descrizione = new StringBuilder();
		for (Nazione n : listaNazioni) {
			descrizione.append(n.toString() + "\n");
		}
		return descrizione.toString();
	}
}
