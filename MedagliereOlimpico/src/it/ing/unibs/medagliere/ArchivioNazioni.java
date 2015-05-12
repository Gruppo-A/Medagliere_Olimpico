package it.ing.unibs.medagliere;

import java.util.ArrayList;

/**
 * Classe ArchivioNazioni nella quale vengono definite le azioni che si possono
 * compiere con un archivio di nazioni e le sue caratteristiche.
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

public class ArchivioNazioni {
	private ArrayList<Nazione> archivio;

	// Stringhe costanti per le eccezioni
	private static final String ERRORE_NOME_DOPPIO = "Il nome della nazione che si sta provando ad inserire è già presente nell' elenco!";
	private static final String ERRORE_AGGIUNGI_NAZIONE = "L'argomento non può essere null!";

	/**
	 * Costruttore di default per la creazione di un arcivio di nazioni
	 */

	public ArchivioNazioni() {
		archivio = new ArrayList<Nazione>();
	}

	/**
	 * Permette di aggiungere una nazione all'archivio
	 * 
	 * @param nazione
	 *            la nazione da aggiugnere all'archivio
	 * 
	 * @throws IllegalArgumentException
	 *             - se la nazione è null - se esiste già una nazione con lo
	 *             stesso nome nell'archivio
	 */

	public void aggiungiNazione(Nazione nazione)
			throws IllegalArgumentException {

		// -**- Il controllo sulla nazione con nome non vuoto sarà fatto nel
		// main con la nostra libreria!

		if (nazione == null) {
			throw new IllegalArgumentException(ERRORE_AGGIUNGI_NAZIONE);
		} else {
			for (Nazione n : archivio) {
				if (n.getNome().equals(nazione.getNome()))
					throw new IllegalArgumentException(ERRORE_NOME_DOPPIO);
			}
		}

		archivio.add(nazione);
	}

	/**
	 * Permette di controllare se una nazione è presente o meno nell'archivio
	 * 
	 * @param nazione
	 *            il nome della nazione di cui controllare la presenza
	 * 
	 * @return - true se la nazione è presente - false se la nazione non è
	 *         presente
	 * 
	 */

	public boolean nazionePresente(String nomeNazione) {
		for (Nazione n : archivio) {
			if (n.getNome().equalsIgnoreCase(nomeNazione))
				return true;
		}

		return false;
	}

	/**
	 * Permette di ottenere il numero di nazioni presenti nell'archivio
	 * 
	 * @return il numero di nazioni presenti nell'archivio
	 */

	public int getNumeroNazioni() {
		return archivio.size();
	}
	
	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		
		for(Nazione n : archivio)
			s.append(n.toString + "%n");
		
		return s.toString();
	}
	
	
}
