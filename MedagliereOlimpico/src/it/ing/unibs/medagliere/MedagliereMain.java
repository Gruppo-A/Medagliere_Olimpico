package it.ing.unibs.medagliere;

import mylib.util.MyMenu;
import mylib.util.MyScanner;

public class MedagliereMain {
	
	private final static String TITOLO_MENU = "Medagliere Olimpico";
	private static final String USCITA_ARCHIVIO = "Se davvero sicuro di voler uscire dal medagliere olimpico";
	private static final String PUNTO_DI_DOMANDA = "?";	//-**- Ho creato questa costante perchè verrà utilizzata tutte le volte che usiamo si_No

	public static void main(String [] args)	{	
		
	
	
		// Creo le voci del menu
				String[] voci = { "Inserisci nuova nazione", "Inserisci nuova gara", "Inserisci il risultato di una gara",
						"Visualizza medagliere" };
				// Flag utilizzato per la condizione di continuazione del ciclo
				boolean continua = true;
				
				// Creo il menu con le voci precedemente create e il nome appena
				// inserito
				MyMenu menu = new MyMenu(TITOLO_MENU, voci);
				
				do {
					// Vado a capo prima di stampare il menu
					System.out.println();
					switch (menu.seleziona()) {
					case 1:
						//-**- AZIONE 1
						break;
					case 2:
						//-**- AZIONE 2
						break;
					case 3:
						//-**- AZIONE 3
						break;
					case 4:
						//-**- AZIONE 4
						break;
					case 5:
						//-**-COPIARE MESSAGGIO DI USCITA SCRITTO DA CADEI IN ARCHIVIOCD!!!!!!
						continua = !(MyScanner.si_No(USCITA_ARCHIVIO + PUNTO_DI_DOMANDA));
					}
				} while (continua);
	}
}
