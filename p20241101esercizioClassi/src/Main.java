import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
			int stLen = 3;
			Scanner scanner = new Scanner(System.in);
			Studente[] studenti = new Studente[stLen]; 
			
			for(int i=0; i<studenti.length; i++) {
				System.out.print("Inserisci Studente n°"+ (i+1) + "\n");
		        
				System.out.print("Inserisci nome: ");
		        String nome = scanner.nextLine();
		        
		        System.out.print("Inserisci matricola: ");
		        String matricola = scanner.nextLine();
		        
		        System.out.print("Inserisci eta: ");
		        int eta = scanner.nextInt(); scanner.nextLine();
		        // scanner.nextInt() lascia nel buffer lo \n quindi 
		        // dobbiamo svuotare il buffer con un altro next()
		        
		        System.out.print("Inserisci corso: ");
		        String corso = scanner.nextLine();
		        
		        System.out.print("Inserisci anno immatricolazione: ");
		        int annoImm = scanner.nextInt(); scanner.nextLine();
		        
		        studenti[i] = new Studente(nome, eta, matricola, corso, annoImm);
			
			}
			
			for(int i=0; i<studenti.length; i++) {
				System.out.println(studenti[i]);
			}
			
			scanner.close();
		
			Arrays.sort(studenti);
		
		
		
	}

}
