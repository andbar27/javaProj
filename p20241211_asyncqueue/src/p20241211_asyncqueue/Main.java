package p20241211_asyncqueue;

/*
Realizzare un programma con due thread, 
un thread produttore e un thread consumatore
i due thread condividono una coda di numeri casuali.
Il primo thread genera ad intervalli casuali (variabili tra
100 e 1000 ms) dei numeri interi casuali e li aggiunge in coda.
IL secondo thread legge i numeri presenti in coda, a
intervalli casuali compresi tra 100 e 500 ms), ne calcola
somma e valor medio e li stampa ogni 2 secondi.
Quindi il secondo thread legge a intervalli casuali e quando
la somma di questi intervalli ha superato i due secondi, stampa
somma e media. Implica il fatto che il secondo thread tra
una lettura e l'altra accumula i valori di somma e media
NB: la media è la somma/numero di elementi letti. Quindi
non dovete ricordare la somma e la media ma dovete ricordare
la somma e il numero di elementi letti.
Il programma non deve terminare mai.
*/

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
