package p20250117_LambdaExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Somma s = (a,b) -> a+b;
		System.out.println(s.somma(1, 2));
		
		Longer l = (a,b) -> a.length() > b;
		System.out.println(l.greatOf("ciao", 5));
		System.out.println(l.greatOf("ciao", 3));
		
		AreaForma cerchio = (a,b) -> a*a*Math.PI;
		System.out.println(cerchio.area(3.0, null));

		System.out.println(exeFun_IntBool(a -> a > 0, 3));
		
		ConcatenaStringhe cs = (a,b) -> a.concat(b);
		System.out.println(cs.concatena("ciao ", "bella"));
		
		Pari n = a -> a % 2 == 0;
		System.out.println(n.isPari(5));
		System.out.println(n.isPari(4));
		
		ArrayList<Integer> li = new ArrayList<Integer>(10);
		for(int i = 0; i<10; i++) {
			li.add(1);
		}
		
		SommaLista sum = ll -> {
			int somma = 0;
			for(int nn : ll)
				somma += nn;
			return somma;
		};
		System.out.println(sum.sommaLista(li));
		
		Function<String, Boolean> f = ss -> {
			int len = ss.length();
			for(int i=0; i<len/2; i++) {
				if(ss.charAt(i) != ss.charAt(len-i-1))
					return false;
			}
			return true;
		};
		System.out.println(f.apply("ciao"));
		System.out.println(f.apply("abba"));
		System.out.println(f.apply("abxba"));
		
		Potenza p = (n1,e) -> {
			if(e == 0) return 1;
			int rn = n1;
			for(int i=1; i<e; i++) {
				rn *= n1;
			}
			return rn;
		};
		System.out.println(p.pot(2, 0));
		System.out.println(p.pot(2, 4));
		
		SommaLista sum1 = ll -> {
			int somma = 0;
			for(int nn : ll)
				somma += nn;
			return somma/ll.size();
		};
		System.out.println(sum1.sommaLista(li));
		


		List<Utente> utenti = new ArrayList<Utente>();
		 
		utenti.add(new Utente("Paolo", "Rossi", 39, "Roma", "test"));
		utenti.add(new Utente("Mario", "Rossi", 40, "Roma", "test"));
		utenti.add(new Utente("Antonio", "Di Girolamo", 23, "Roma", "test"));
		utenti.add(new Utente("Caterina", "Montefalco", 55, "Roma", "test"));
		utenti.add(new Utente("Valeria", "Natelli", 45, "Roma", "test"));
		utenti.add(new Utente("Giovanna", "D'Antonelli", 50, "Roma", "test"));
		utenti.add(new Utente("Paolo", "Pisani", 21, "Catanzaro", "test"));
		utenti.add(new Utente("Laura", "Gambaro", 19, "Roma", "test"));
		utenti.add(new Utente("Benedetto", "Satini", 38, "Roma", "test"));
		
		System.out.println(cercaUtenti(utenti, u -> u.getEta() > 40));

		Function<String, Boolean> f12 = s12 -> s12.isEmpty();
		System.out.println(f12.apply(""));
		System.out.println(f12.apply("a"));
		
		List<String> colors = Arrays.asList("red", "green", "blue", "black", "pink");
		Function<List<String>,List<String>> f22 = l22 -> {Collections.sort(l22); return l22;};
		System.out.println(f22.apply(colors));
		
		Consumer<Integer> cons = n2 -> { System.out.println(n2); };
		li.forEach( cons );
	}

	private static boolean exeFun_IntBool(Function<Integer, Boolean> f, Integer operando) {
		return f.apply(operando);
	}
	
	private static List<Utente> cercaUtenti(List<Utente> li, Predicate<Utente> p){
		List<Utente> lr = new ArrayList<Utente>();
		
		for(Utente u : li) {
			if(p.test(u))
				lr.add(u);
		}
		return lr;
	}
	

}
