package p20241213_Manufatturiera;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/*
 * Un'azienda manifatturiera ha un gruppo di macchine filatrici che producono
 * tessuti di tipo differente.
 * - Cotone
 * - Lino
 * - Lana
 * - Seta
 * - Poliestere
 * - Nylon
 * Ogni filatrice è governata da un'applicazione software che scrive 
 * su un file (specifico della filatrice) a intervalli regolari la 
 * quantità (in metri) e il tipo di tessuto prodotto.
 * 
 * Tutti i file sono scritti su un file system condiviso in modo da
 * consentirne l'uso da parte di un gestore centralizzato.
 * L'applicazione per la gestione centralizzata è organizzata in due moduli principali
 * - modulo produttore
 *  - legge ciclicamente i file prodotti dalle varie filatrici e appende
 *    i dati di produzione in una coda (LinkedBlockingQueue) che gestisce automaticamente
 *    la concorrenza degli accessi
 * - modulo consumatore
 *  - acquisisce i dati di produzione dalla linkedblockingqueue e forma dei report
 *    su base oraria che stampano i totali di produzione per ogni macchina e per 
 *    ogni tipologia di tessuto
 *    NB: una filatrice può produrre tipi di dfferenti di tessuto
 * 
 * Realizzare una soluzione software basata su 2 applicazioni (che simulano le filatrici)
 * e ogni 10 secondi (per semplicità del testing) aggiornano i file di produzione.
 * I file di produzione hanno un nome che corrisponde al numero della filatrice
 * Esempio: sia <filatrice> il nome dell'app filatrice
 *  con il comando <java filatrice 3> attivo l'applicazione filatrice 
 *  assegnandogli il numero 3.
 *  Questa, ogni 10 secondi, scriverà nel file produzione_filatrice_1.dat
 *  una riga (in formato JSON) che descrive l'elenco e la quantità dei tessuti prodotti
 *  
 *  Il programma di gestione, attraverso il modulo produttore, scandisce ciclicamente i
 *  file produzione_filatrice_1.dat e produzione_filatrice_2.dat (sono due macchine)
 *  legge i dati e li mette in coda.
 *  il modulo consumatore, legge dalla coda, accumula per macchina e accumula per
 *  tessuto e ogni minuto stampa un report sui livelli di produzione
 *  
 *  Opzionale: se il report fosse stampato in un file CSV allora con excel 
 *  si potrebbe leggere e graficizzare
 * */

public class Filatrice{
	private Integer idf;
	public static String[] tessuti = {"Lino", "Cotone", "Lana", "Seta", "Poliestere", "Nylon"};
	
	
	protected Filatrice(Integer id) {
		super();
		this.idf = id;
	}


	public Integer getIdf() {
		return idf;
	}


	public void setId(Integer id) {
		this.idf = id;
	}
	
	
	public String produci() {
		Random rng = new Random();
		
		Integer tessuto = rng.nextInt(0, tessuti.length);
		Integer metri = rng.nextInt(1, 10);
		
		String prodotto = "{\"tessuto\":\"" + tessuti[tessuto] + "\",\"metri\":" + metri + "}";
		
		
        try {
        	FileWriter writer = new FileWriter("/tmp/filatrice" + this.getIdf() + ".dat", true); // true per append
			writer.write(prodotto + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return(prodotto);
	}
	
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(produci());
		}
		
	}
	
	
	
}
