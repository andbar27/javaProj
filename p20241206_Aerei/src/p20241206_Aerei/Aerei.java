package p20241206_Aerei;

import com.fasterxml.jackson.core.JsonProcessingException;

/*
 * Realizzare un progetto che simuli
 * - un'agenza di viaggi con le funzionalità di prenotazione volo e cancellazione volo
 * - un insieme di compagnie aeree dove ognuna esporta i servizi di
 * - prenotazione volo
 * - cancellazione volo
 * verso le agenzie
 *  e verso gli aeroporti le funzioni di
 *  - imbarco (implica che i voli non sono più prenotabili)
 *  - decollo (ora del decollo di uno specifico aereo della compagnia dall'aeroporto che sta inserendo i dati di decollo)
 *  - atterraggio (ora di atterraggio di un aereo della compagnia dall'aeroporto che sta inserendo i dati di atterraggio)
 *  
 *   NB:
 *    - è sufficiente una sola agenzia
 *    - le compagnie aeree hanno un menu particolare che gli consente di aggiungere e eliminare aerei (numero di posti)
 *  Un esempio di sessione di lavoro la seguente:
 *  Menu Generale
 *  Menu per agenzia
 *  prenotazione
 *  disdetta
 *  Menu per aeroporto
 *  imbarco
 *  decollo
 *  atterraggio
 *  Menu per compagnia aerea
 *  crea aereo
 *  elimina aereo
 *  
 *  ovviamente la compagnia aerea predispone una lista di voli (da, a, orario, nome aereo) utilizzabile per le prenotazioni e per gli imbarchi, e i voli
 *  Abbiamo quindi N compagnie aeree e M aeroporti
 *  Inoltre il menu prevede un comando di termine lavoro che salva su file 
 *  la situazione globale del sistema (le compagnie aeree con gli aerei, e lo stato delle prenotazioni, decolli, atterraggi e imbarchi)
 *  All'avvio il programma recupera da file tutti i dati.
 *  Al termine di un volo, atterraggio, i dati sono archiviati in una lista qassociata ad ogni aeroporto
 *   
 */

public class Aerei {
	
	public static void menu() throws JsonProcessingException {
		Agenzia ag = new Agenzia();
		Volo v;
		Compagnia c = new Compagnia();
		System.out.println("crea aereo");
		Aereo a = c.creaAereo("aer", 30);
		
		System.out.println("elimina aereo");
		c.eliminaAereo(a.nome);
		
		System.out.println("crea volo");
		v = c.creaVolo(a);
		
		System.out.println("elimina volo");
		c.eliminaVolo(v);
		
		System.out.println("prenota aereo");
		v.prenota(5);
		
		System.out.println("disdici aereo");
		v.disdetta(2);
		
		System.out.println("imbarca aereo");
		v.imbarca();
		
		System.out.println("Archivia agenzia");
		String jsonS = ag.generateJSON();
		
		System.out.println("Genera agenzia da Json");
		Agenzia ag2 = Agenzia.generateByJSON(jsonS);
		
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		Compagnia comp = new Compagnia();
		comp.creaAereo("Arita", 20);
		comp.creaVolo(comp.lista_aerei.get(0));
		comp.lista_voli.get(0).prenota(10);
		comp.lista_voli.get(0).imbarca();
		
		Agenzia a = new Agenzia();
		a.addCompagnia(comp);
		
		String jsonS = a.generateJSON();
		Agenzia a1 = Agenzia.generateByJSON(jsonS);
		String jsonS2 = a1.generateJSON();
		
		System.out.println(jsonS.equals(jsonS2));
	}

}
