package it.ing.unibs.medagliere;

/**
 * Classe Gara nella quale vengono definite le azioni che si possono compiere con
 * una gara e le sue caratteristiche.
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

public class Gara {

	private String nome;
	//private final static String NOME_DEFAULT = "gara";
	
	/**
	 * Costruttore per la creazione di una gara utilizzando 
	 * il suo nome
	 * 
	 * @param nome
	 *        il nome della gara
	 */
	
	public Gara(String nome)
	{
		this.nome = nome;
	}
	
	/*
	 * 
	 * SENZA IL SETTER NON HA SENSO!
	  Costruttore di default per la creazione di una gara
	 
	
	public Gara()
	{
		this(NOME_DEFAULT);
	}
	
	*/
	
	/**
	 * Getter dell'attributo nome
	 * 
	 * @return il nome della gara
	 */
	
	public String getNome()
	{
		return nome;
	}	
	
	
	//-**- non ho creato il setter perchè ogni gara è univoca. 
	//-**- Non voglio che qualcuno cambi il nome della gara
	
	//-**- IN UN PROGETTO GENERICO ANDREBBE MESSO! Quindi decidiamo cosa fare
	
}
