package p20112024_01_Esercizio;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
	
	public static <T1,T2> void swapCoppia(Coppia<T1,T2> o1, Coppia<T1,T2> o) {
		Coppia<T1,T2> temp = new Coppia<T1,T2>(o1.getF(), o1.getS());
		
		o1.setF(o.getF());
		o1.setS(o.getS());
		
		o.setF(temp.getF());
		o.setS(temp.getS());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoppiaInt a = new CoppiaInt(1,1);
		int[] arr = new int[4];
		arr [1] = 45;
		LinkedList<Integer> p;
		
		Coppia<Integer,Double> a1 = new Coppia<Integer, Double>(1,2.0);
		
		Coppia<Integer,Double> a2 = new Coppia<Integer, Double>(111,112.0);
		
		System.out.println(a1 + " ; " + a2);
		swapCoppia(a1,a2);
		System.out.println(a1 + " ; " + a2);
		a1.swapCoppia(a2);
		System.out.println(a1 + " ; " + a2);
		
		System.out.println();
		
		Coppia<String,String> a11 = new Coppia<String, String>("a","b");
		
		Coppia<String,String> a22 = new Coppia<String, String>("c","d");
		
		System.out.println(a11 + " ; " + a22);
		swapCoppia(a11,a22);
		System.out.println(a11 + " ; " + a22);
		a11.swapCoppia(a22);
		System.out.println(a11 + " ; " + a22);
		
		System.out.println();
		
		LinkedList<Integer> li = new LinkedList<Integer>();
		li.addAll(Arrays.asList(new Integer[]{3,4,6,2,3,7,8}));
		System.out.println(li);
		swapListOn(li, 2, 6);
		System.out.println(li);
		
		
		System.out.println("\n\n\nAutomezzi:\n");
		
		LinkedList<Automezzo> la = new LinkedList<Automezzo>();
		la.add(new Motociclo(1, "disel", 2, 6));
		la.add(new Autovettura(1, "disel", 2, 6));
		la.add(new Motociclo(2, "benz", 2, 3));
		la.add(new Motociclo(2, "benz", 2, 5));
		la.add(new Autovettura(2, "benz", 2, 3));
		la.add(new Autovettura(2, "benz", 2, 5));
		la.add(new Motociclo(2, "benz", 2, 1));
		la.add(new Motociclo(2, "benz", 2, 2));
		la.add(new Autovettura(2, "benz", 2, 7));
		la.add(new Autovettura(2, "benz", 2, 6));
		
		
		System.out.println(la);
		
		Collections.sort(la);
		System.out.println(la);
	}

	private static void swapListOn(LinkedList<Integer> li, int n, int m) {
		Iterator i = li.iterator();
		Iterator j = li.iterator();
		
		int tempI; 
		for(int ii = 0; ii < n-1; ii++) {
			i.next();
		}
		tempI = (int) i.next();
		
		for(int jj = 0; jj < m-1; jj++) {
			j.next();
		}
		int tempJ = (int) j.next();
		
		li.set(n-1, tempJ);
		li.set(m-1, tempI);
		
	}

}
