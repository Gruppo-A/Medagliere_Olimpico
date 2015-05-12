package it.ing.unibs.medagliere;

/**
 * Classe Nazione nella quale vengono definite le azioni che si possono compiere con
 * una nazione e le sue caratteristiche.
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

public class Nazione {

	private String nome;	
	private int medaglia[];
	
	// Stringhe costanti per le eccezioni
	//private final static String NOME_DEFAULT = "nazione";
	private final static String ERRORE_INSERISCI_MEDAGLIA = "Valore inserito non valido!";
	
	/**
	 * Costruttore per la creazione di una nazione utilizzando
	 * il nome dello stato
	 * 
	 * @param nome
	 *        il nome della nazione
	 */
	
	public Nazione(String nome)
	{
		this.nome = nome;
		medaglia = new int[Medaglie.NUM_MEDAGLIE];
	}
	
	
	
	
	/*
	
	  SENZA IL SETTER NON HA SENSO!
	
	  Costruttore generico per la creazione di una nazione
	
	
	public Nazione()
	{
		this(NOME_DEFAULT);
		medaglia = new int[Medaglie.NUM_MEDAGLIE];
	}
	
	*/
	
	
	
	/**
	 * Getter dell'attributo nome
	 * 
	 * @return il nome della nazione 
	 */
	
	public String getNome()
	{
		return nome;
	}
	
	//-**- non ho creato il setter perchè ogni nazione è univoca. 
	//-**- Non voglio che qualcuno cambi il nome della nazione
			
	//-**- IN UN PROGETTO GENERICO ANDREBBE MESSO! Quindi decidiamo cosa fare
	
	/**
	 * Permette di aggiungere una medaglia per tipo
	 *       
	 * @param valoreMedaglia
	 *        il tipo della medaglia: 
	 *        - 1 per ORO, 
	 *        - 2 per ARGENTO,
	 *        - 3 per BRONZO
	 *        
	 * @throws IllegalArgumentException
	 *         se valoreMedaglia non è compreso tra i valori permessi
	 */
	
	public void aggiungiMedaglia(int valoreMedaglia) throws IndexOutOfBoundsException
	{
		// Se valoreMedaglia non è compreso tra 1 e 3 della lista è lanciata
		// una IndexOutOfBoundsException
				if(valoreMedaglia < 1 || valoreMedaglia > Medaglie.NUM_MEDAGLIE)
						throw new IndexOutOfBoundsException(ERRORE_INSERISCI_MEDAGLIA);
		medaglia[valoreMedaglia]++;
	}
	
	
	
}
