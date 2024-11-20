package p20241113_01_resume;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> li = new LinkedList<Integer>();
		
		li.add(7);
		li.add(5);
		li.add(9);
		li.add(2);
		
		Collections.sort(li);
		
		System.out.println(li);
		
		System.out.println(Collections.max(li));
		
		Collections.shuffle(li);
		System.out.println(li);

		Ghepardo g1 = new Ghepardo(15,60,90.0);
		Ghepardo g2 = new Ghepardo(13,66,105.0);
		Ghepardo g3 = new Ghepardo(16,50,95.0);
		Ghepardo g4 = new Ghepardo(14,55,85.0);
		
		LinkedList<Ghepardo> lg = new LinkedList<Ghepardo>();
		
		lg.add(g1);
		lg.add(g2);
		lg.add(g3);
		lg.add(g4);
		
		System.out.println(lg);
		
		Collections.shuffle(lg);
		lg.sort(new Comparator<Ghepardo>() {
			public int compare(Ghepardo g1, Ghepardo g2) {
				return g1.compareTo(g2);
			}
		});
		
		System.out.println(lg);
		
		LinkedList<Elefante> le = new LinkedList<Elefante>();
		
		le.add(new Elefante(5, 10, 4500.0));
		le.add(new Elefante(4, 11, 4550.0));
		le.add(new Elefante(5, 9, 4500.0));
		le.add(new Elefante(5, 10, 4600.0));
		
		LinkedList<Mammifero> lm = new LinkedList<Mammifero>();
		
		for(Elefante e : le) 
			lm.add(e);
		
		for(Ghepardo g : lg)
			lm.add(g);
		
		// Procedura merge, usiamo due liste di int già ordinate
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l1.add(3);
		l1.add(8);
		l1.add(11);
		l2.add(1);
		l2.add(2);
		l2.add(3);
		l2.add(4);
		l2.add(9);
		l2.add(12);
		l2.add(15);
		
		LinkedList<Integer> lsorted = MergeList(l1,l2);
		
		System.out.println("\n\n" + lsorted);
	}

	private static LinkedList<Integer> MergeList(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		// 0) Impariamo ad usare gli iteratori.
		
		// Usando un iteratore, stampare una lista
//		Iterator<Integer> it = l1.iterator();
//		while(it.hasNext()) {
//			Integer num = it.next();
//			System.out.println(num);
//		}
		
		// 1) Creo la lista risultato
		LinkedList<Integer> lret = new LinkedList<Integer>();
		
		// 2) Faccio la merge delle 2 liste ordinate
		Iterator<Integer> it1 = l1.iterator();
		Iterator<Integer> it2 = l2.iterator();
		
		if(l1 == null || l1.size() == 0)
			return l2;
		
		if(l2 == null || l2.size() == 0)
			return l1;
		
		Integer n1 = it1.next(); 
		Integer n2 = it2.next();
		while(true) {
			if(n1 <= n2) {
				lret.add(n1);
				if(it1.hasNext()) 
					n1 = it1.next();
				else {
					lret.add(n2);
					while(it2.hasNext()) {
						lret.add(it2.next());
					}
					return lret;
				}
			} else {
				lret.add(n2);
				if(it2.hasNext()) 
					n2 = it2.next();
				else {
					lret.add(n1);
					while(it1.hasNext()) {
						lret.add(it1.next());
					}
					return lret;
				}
			}
		}
		
	}

}
