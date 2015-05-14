package it.ing.unibs.medagliereOlimpico;

import java.util.ArrayList;

/**
 * Classe ArchivioGare nella quale vengono definite le azioni che si possono
 * compiere con un archivio di gare e le sue caratteristiche.
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

public class ArchivioGare {

	ArrayList<Gara> listaGare;

	// Stringhe costanti per le eccezioni
	private final static String ERRORE_GARA_NULL = "La gara che stai cercando di aggiungere deve esistere!";
	private final static String ERRORE_GARA_DOPPIA = "La gara che stai cercando di aggiungere e' gia' presente!";
	private final static String ERRORE_GARA_ASSENTE = "La gara cercata non fa parte dell'archivio!";

	/**
	 * Costruttore di default per la creazione di un archivio di gare
	 */
	public ArchivioGare() {
		listaGare = new ArrayList<>();
	}

	/**
	 * Permette di aggiungere una gara all'archivio
	 * 
	 * @param gara
	 *            la gara da aggiugnere all'archivio
	 * 
	 * @throws IllegalArgumentException
	 *             - se la gara è null 
	 *             - se esiste già una gara con lo stesso
	 *               nome nell'archivio
	 */
	public void aggiungiGara(Gara gara) throws IllegalArgumentException {
		if (gara == null)
			throw new IllegalArgumentException(ERRORE_GARA_NULL);

		for (Gara g : listaGare) {
			if (g.getNome().equals(g.getNome()))
				throw new IllegalArgumentException(ERRORE_GARA_DOPPIA);
		}

		listaGare.add(gara);
	}

	/**
	 * Permette di controllare se una gara è presente 
	 * o meno nell'archivio
	 * 
	 * @param nomeGara
	 *            il nome della gara di cui controllare la presenza
	 * 
	 * @return - true se la gara è presente 
	 *         - false se la gara non è presente
	 * 
	 */
	public boolean contieneGara(String nomeGara) {		
		for (Gara g : listaGare) {
			if (g.getNome().equalsIgnoreCase(nomeGara))
				return true;
		}
		return false;
	}
	
	/**
	 * Permette di ottenre una gara dell'archivio dal suo nome
	 * 
	 * @param nomeGara
	 *        il nome della gara che si vuole ottenere
	 *        
	 * @return la gara richiesta (se fa parte dell'archivio)
	 * 
	 * @throws NullPointerException
	 *         se la gara cercata non fa parte dell'archivio
	 */
	public Gara getGara(String nomeGara) throws NullPointerException {
		for (Gara gara : listaGare)
			if (gara.getNome().equalsIgnoreCase(nomeGara))
				return gara;

		throw new NullPointerException(ERRORE_GARA_ASSENTE);
	}	

	@Override
	public String toString() {

		StringBuilder descrizione = new StringBuilder();
		for (Gara g : listaGare) {
			descrizione.append(g.toString() + "\n");
		}

		return descrizione.toString();
	}	
}
