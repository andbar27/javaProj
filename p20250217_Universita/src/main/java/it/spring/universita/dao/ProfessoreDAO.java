package it.spring.universita.dao;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.spring.universita.entity.Professore;




public class ProfessoreDAO {

	private Map<Integer, Professore> mappa = new HashMap<>();

	public boolean insert(Professore professore) {
		if(mappa.containsKey(professore.getId()))
			return false;
		
		mappa.put(professore.getId(), professore);
		return true;
	}
	
	public List<Professore> selectAll(){
		return new ArrayList<Professore>(mappa.values());
	}

	public Professore selectById(Integer idProfessore) {
		return mappa.get(idProfessore);
	}
	
	public boolean delete(Integer idProfessore) {
		Professore professore = mappa.remove(idProfessore);
		return professore!=null;
	}
	
	

}


