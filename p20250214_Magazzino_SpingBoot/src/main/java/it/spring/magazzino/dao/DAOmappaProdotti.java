package it.spring.magazzino.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.spring.magazzino.entity.Prodotto;



public class DAOmappaProdotti {

	private Map<Integer, Prodotto> mappa = new HashMap<>();

	public boolean insert(Prodotto prodotto) {
		if(mappa.containsKey(prodotto.getId()))
			return false;
		
		mappa.put(prodotto.getId(), prodotto);
		return true;
	}
	
	public List<Prodotto> selectAll(){
		return new ArrayList<Prodotto>(mappa.values());
	}

	public Prodotto selectById(Integer idProdotto) {
		return mappa.get(idProdotto);
	}
	
	public boolean delete(Integer idProdotto) {
		Prodotto prodotto = mappa.remove(idProdotto);
		return prodotto!=null;
	}
	
	

}

