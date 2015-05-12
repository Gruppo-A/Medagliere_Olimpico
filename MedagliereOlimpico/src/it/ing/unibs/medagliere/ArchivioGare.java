package it.ing.unibs.medagliere;

import java.util.ArrayList;

/**
 * Classe ArchivioGare nella quale vengono definite le azioni che si possono compiere con
 * un archivio di gare e le sue caratteristiche.
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

public class ArchivioGare {

	private ArrayList<Gara> archivio;
	
	// Stringhe costanti per le eccezioni
	private static final String ERRORE_NOME_DOPPIO = "Il nome della gara che si sta provando ad inserire è già presente nell' elenco!";
	private static final String ERRORE_AGGIUNGI_GARA = "L'argomento non può essere null!";

	
	/**
	 * Costruttore di default per la creazione di un archivio di gare
	 */
	
	public ArchivioGare() {
		archivio = new ArrayList<Gara>();
	}
	
	/**
	 * Permette di aggiungere una gara all'archivio
	 * 
	 * @param gara
	 *        la gara da aggiugnere all'archivio
	 *        
	 * @throws IllegalArgumentException
	 *         - se la gara è null
	 *         - se esiste già una gara con lo stesso
	 *           nome nell'archivio 
	 */

	public void aggiungiGara(Gara gara) throws IllegalArgumentException {
		
		//-**- Il controllo sulla gara con nome non vuoto sarà fatto nel main con la nostra libreria!
		
		if (gara == null) {
			throw new IllegalArgumentException(ERRORE_AGGIUNGI_GARA);
		} else {
			for (Gara g : archivio) {
				if (g.getNome().equals(gara.getNome()))
					throw new IllegalArgumentException(ERRORE_NOME_DOPPIO);
			}
		}

		archivio.add(gara);
	}
	
	
	/**
	 * Permette di controllare se una gara è presente o meno 
	 * nell'archivio
	 * 
	 * @param nomeGara
	 *        il nome della gara di cui controllare la 
	 *        presenza
	 *        
	 * @return - true se la gara è presente
	 *         - false se la gara non è presente
	 *     
	 */
	
	public boolean garaPresente(String nomeGara)
	{
		for (Gara g : archivio) {
			if (g.getNome().equalsIgnoreCase(nomeGara)) //-**- IgnoreCase perchè non so come l'utente inserisca la Stringa con il nome della gara, magari è un FASCISTA
				return true;
		}
		
		return false;
	}
	
	/**
	 * Permette di ottenere il numero di gare presenti
	 * nell'archivio
	 * 
	 * @return il numero di gare presenti nell'archivio
	 */
	
	public int getNumeroGare()
	{
		return archivio.size();
	}

}
