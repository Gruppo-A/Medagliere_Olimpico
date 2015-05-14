package it.ing.unibs.medagliereOlimpico;

import mylib.util.MyMenu;
import mylib.util.MyScanner;

/**
 * Classe contenente il main per la gestione dell'interfaccia 
 * con l'utente del medagliere olimpico
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

public class Main {	
	private final static String ERRORE_INSERISCI_GARA = "La gara inserita non esiste!!";
	private final static String ERRORE_INSERISCI_NAZIONE = "La nazione inserita non esiste!!";
	private final static String RICHIAMO = "ATTENZIONE: ";
	private final static String RIPROVA = "Riprova: ";
	private final static String INSERISCI_GARA = "Inserisci il nome della gara per favore: ";
	private final static String INSERISCI_NAZIONE = "Inserisci il nome della nazione per favore: ";
	private final static String USCITA_MEDAGLIERE = "Sei davvero sicuro di volere uscire dal medagliere?";
	private final static String TITOLO = "Medagliere olimpico";
	private final static String[] vociMenu = { "Inserisci nazione",	"Inserisci gara", "Inserisci risultati" };

	private static ArchivioNazioni archivioNazioni = new ArchivioNazioni();
	private static ArchivioGare archivioGare = new ArchivioGare();

	public static void main(String[] args) {

		// Variabile utilizzata per la condizione di uscita dal ciclo principale
		// del programma
		boolean continua = true;
		// Creazione del menu principale
		MyMenu menu = new MyMenu(TITOLO, vociMenu);

		do {
			// Il menu principale
			// lo switch è effettuato sulla scelta della voce di menu
			// dell'utente
			switch (menu.seleziona()) {
			case 1:
				// Provo ad aggiungere una nazione
				aggiungiNazione();
				break;
			case 2:
				aggiungiGara();
				break;
			case 3:
				inserisciRisultati();
				break;
			case 4:
				continua = !(MyScanner.si_No(USCITA_MEDAGLIERE));
			}
		} while (continua);

	}

	private static void aggiungiNazione() {
		String lettura = MyScanner.leggiStringaNonVuota(INSERISCI_NAZIONE);
		try {
			archivioNazioni.aggiungiNazione(new Nazione(lettura));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void aggiungiGara() {
		String lettura = MyScanner.leggiStringaNonVuota(INSERISCI_GARA);
		try {
			archivioGare.aggiungiGara(new Gara(lettura));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void inserisciRisultati() {
		String gara = MyScanner.leggiStringaNonVuota(INSERISCI_GARA);
		if (archivioGare.contieneGara(gara)) {
			for (Medaglia m : Medaglia.values()) {
				System.out.println(m + ": ");
				String nomeNazione = inserisciNazioneEsistente();
				// Una volta inserita la nazione le aggiungo la medaglia
				// corrispondente
				archivioNazioni.getNazione(nomeNazione).aggiungiMedaglia(m);
			}
		} else {
			System.out.println(RICHIAMO + ERRORE_INSERISCI_GARA);
		}
	}

	private static String inserisciNazioneEsistente() {
		boolean finito = false;
		String lettura = null;
		do {
			lettura = MyScanner.leggiStringaNonVuota("");
			if (archivioNazioni.contieneNazione(lettura))
				finito = true;
			else 
				System.out.println(RICHIAMO + ERRORE_INSERISCI_NAZIONE + RIPROVA);
			     
		} while (!finito);

		return lettura;
	}

}
