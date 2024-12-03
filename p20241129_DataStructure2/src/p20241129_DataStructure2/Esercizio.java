package p20241129_DataStructure2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Esercizio {

	public static void main(String[] args) {
		// 
		
		HashSet<Prova> hsp = new HashSet<Prova>();
		TreeSet<Prova> tsp = new TreeSet<Prova>();
		
		HashMap<Prova, Integer> hmp = new HashMap<Prova, Integer>();
		TreeMap<Prova, Integer> tmp = new TreeMap<Prova, Integer>();
		
		for(int i=0; i<100; i++) {
			hsp.add(new Prova(i));
			tsp.add(new Prova(i));
			
		}
		
		hsp.contains(new Prova(10)); // OBV non funge
	}

}

class Prova{
	public String uno;
	public int due;
	
	public Prova(int n) {
		uno = "uno";
		due = n;
	}
	
}
