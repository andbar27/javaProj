package esercizioClassi;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int stLen = 3;
		Scanner scanner = new Scanner(System.in);
		Studente[] studenti = new Studente[stLen]; 
		
		for(int i=0; i<studenti.length; i++) {
			System.out.print("Inserisci Studente n°"+ i+1 + "\n");
	        
			System.out.print("Inserisci nome: ");
	        String nome = scanner.nextLine();
	        
	        System.out.print("Inserisci matricola: ");
	        String matricola = scanner.nextLine();
	        
	        System.out.print("Inserisci eta: ");
	        int eta = scanner.nextInt();
	        
	        
	        
	        studenti[i] = new Studente(nome, eta, matricola);
		
		}
		
		for(int i=0; i<studenti.length; i++) {
			System.out.println(studenti[i]);
		}
		
		
		scanner.close();
	}

}
