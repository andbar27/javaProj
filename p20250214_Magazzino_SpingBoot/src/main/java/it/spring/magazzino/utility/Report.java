package it.spring.magazzino.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.spring.magazzino.entity.Prodotto;

public class Report {
	
	public static List<String> getDescrizioni(List<Prodotto> lp){
		List<String> descrizioni = new ArrayList<String>();
		for(Prodotto p : lp) 
			descrizioni.add(p.getDescrizione());
		
		
		return descrizioni;
	}
	
	public static int sumQuantita(List<Prodotto> lp) {
		int somma = 0;
		for(Prodotto p : lp) 
			somma += p.getN_pezzi();
		
		return somma;
			
	}
	
	public static List<String> prodIndisponibili(List<Prodotto> lp){
		List<String> indisponibili = new ArrayList<String>();
		for(Prodotto p : lp) {
			if(p.getN_pezzi() == 0)
				indisponibili.add(p.getModello());
		}
		
		return indisponibili;
	}
	
	public static double mediaPrezzi(List<Prodotto> lp) {
		double media = 0;
		int size = 0;
		for(Prodotto p : lp) {
			media += p.getPrezzo_consigliato();
			size++;
		}
		return media / size;
	}
	
	public static Map<String, List<Integer>> mappaCategoriaId(List<Prodotto> lp){
		Map<String, List<Integer>> mappa = new HashMap<String, List<Integer>>();
		
		for(Prodotto p : lp) {
			String cat = p.getCategoria();
			int id = p.getId();
			
			if(!mappa.containsKey(cat))
				mappa.put(cat, new ArrayList<Integer>());
			
			mappa.get(cat).add(id);
		}
		
		return mappa;
	}


}
