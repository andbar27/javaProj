import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		if (false) {
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
		        int eta = scanner.nextInt(); scanner.next();
		        // scanner.nextInt() lascia nel buffer lo \n quindi 
		        // dobbiamo svuotare il buffer con un altro next()
		        
		        
		        
		        studenti[i] = new Studente(nome, eta, matricola);
			
			}
			
			for(int i=0; i<studenti.length; i++) {
				System.out.println(studenti[i]);
			}
			
			
			// Con Parse Class, NON FUNZIONA CON SOTTOCLASSI ):
			Studente s1 = (Studente)ParseClass.Parse(Studente.class);
			
			
			scanner.close();
		
		
		LinkedList<Studente> lStud = new LinkedList<Studente>();
		lStud.add((Studente)ParseClass.Parse(Studente.class));
		lStud.add((Studente)ParseClass.Parse(Studente.class));
		
		System.out.println(lStud);
		}
		LinkedList<Integer> li = new LinkedList<Integer>();
		li.add(10);
		li.add(20);
		li.add(1);
		System.out.println(li);
		
		Collections.sort(li);
		System.out.println(li);
		
		Collections.reverse(li);
		
		
		
	}

}
