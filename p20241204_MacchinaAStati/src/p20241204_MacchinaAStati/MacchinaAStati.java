package p20241204_MacchinaAStati;

import java.util.Scanner;
import java.util.regex.Pattern;

/*
Scrivere un programma java che data una stringa che contiene digit, 
può iniziare con il carattere + o - e può contenere un . seguito da
altri digit, la converte, se possibile, in numero reale
esempio: 
Corretto: -234243.432
Errato: --123
Errato: -123-11.1
Errato: 123.11.11.22
Corretto: 123
Corretto: 123.
Corretto: +123
Corretto: -123.
Corretto: -123.33333333333333333
Il codice deve essere realizzato secondo un modello Produttore/Consumatore
Dove il produttore scandisce la stringa di input carattere per carattere e, 
per ogni carattere chiama il Consumatore passandogli il carattere scandito.
Quando il produttore invia al consumatore il carattere '\n', il consumatore
quando riceve il carattere '\n', se il numero è stato formato correttamente
lo stampa, altrimenti stampa "Errore". Analogamente il consumatore stamperà errore
nel caso in cui si accorga di un errore nel numero letto. 
Esempio: +123.34. Stampa errore non appena riscontra il secondo carattere .
Esempio di implementazione:
void Produttore(String in) {
    for (int i=0; i<in.length(); i++) {
        Consumatore(in.charAt(i));
    }
}
static double numero=0.0;
void Consumatore(char c) {
    if (c == '\n') {
        System.out.println("Il numero è: " + numero); 
    } else {
        //Qui il codice per formare il numero
        //NB: se c è un digit tra 0 e 9, allora c-'0' è un numero tra 0 e 9 
    }
} */
public class MacchinaAStati {

	
	
	public static boolean isNumber(String input) {
		String num = "0123456789";
		int stato = 0;
		
		for(int i = 0; i<input.length(); i++) {
			char c = (input.charAt(i));
			//System.out.println(c + " " + stato);
			switch(stato) {
				case 0:
					if(c == '-') {
						stato = 1;
					} else { 
						if (num.indexOf(c) != -1) {
							stato = 2;
						} else {
							stato = 5;
						}
					}
					break;
					
				case 1:
					if(num.indexOf(c) != -1)
						stato = 2;
					else
						stato = 5;
					break;
				
				case 2:
					if(num.indexOf(c) != -1) {
						continue;
					} else { 
						if (c == '.') {
							stato = 3;
						} else {
							stato = 5;
						}
					}
					break;
					
				case 3: 
					if(num.indexOf(c) != -1)
						stato = 4;
					else
						stato = 5;
					break;
				
				case 4:
					if(num.indexOf(c) != -1)
						stato = 4;
					else
						stato = 5;
					break;
					
				case 5:
					return false;
			}
			
		}
		if(stato == 5 || stato <= 1)
			return false;
		return true;
	}
	
	public static int mapEvent(char c) {
		String num = "0123456789";
		
		if(c == '-')
			return 0;
		
		if(num.indexOf(c) != -1)
			return 1;
		
		if(c == '.')
			return 2;
		
		return 4;
	}
	
	public static boolean isNumber2(String input) {
		int E = 4;
		int S = 5;
		int [][] mas = 
			{
				{1, 2, E, E, E}, 
				{E, 2, E, E, E},
				{E, 2, 3, S, E},
				{E, 3, E, S, E},
				{E, E, E, E, E},
				{S, S, S, S, E}
			};
		
		int STATO = 0;
		int EVENTO; 
		
		for(int i = 0; i<input.length(); i++) {
			EVENTO = mapEvent(input.charAt(i));
			STATO = mas[STATO][EVENTO];
		}
		EVENTO = 3;
		STATO = mas[STATO][EVENTO];
		
		return(STATO == S);
		
	}
	
	public static void main(String[] args) {
		// -?[0-9]+(.[0-9]*)?
		// Stati:
		// 1) -?
		// 2) [0-9]+
		// 3) (.[0-9]*)?
		String regex = "-?\\d+(.\\d*)?";
		
		String num = "";
		
		Scanner scan = new Scanner(System.in);
		
		//while(num != "chiudi") 
		{
			num = scan.nextLine();
			if(num.matches(regex)) 
				System.out.println("corretto " + num);
			else 
				System.out.println("non corretto " + num);
		}
		
		
		///////////////////
		String input = "";
		while(input != "chiudi") {
			input = scan.nextLine();
			
			System.out.println(isNumber2(input));
			
		}

		scan.close();
	}

}
