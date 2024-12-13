package Produttore;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

public class Main {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		Gestione g = new Gestione();
		Cliente c = new Cliente(g.getCoda());
		
		g.start();
		c.start();

	}

}
