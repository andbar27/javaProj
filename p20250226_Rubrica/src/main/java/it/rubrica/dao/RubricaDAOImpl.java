package it.rubrica.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import it.rubrica.entity.Rubrica;

@Repository
public class RubricaDAOImpl implements RubricaDAO{
	private Map<Integer, Rubrica> mappa = new HashMap<>();

	public boolean insert(Rubrica rubrica) {
		if(mappa.containsKey(rubrica.getId()))
			return false;
		
		mappa.put(rubrica.getId(), rubrica);
		return true;
	}
	
	public List<Rubrica> selectAll(){
		return new ArrayList<Rubrica>(mappa.values());
	}

	public Rubrica selectById(Integer idRubrica) {
		return mappa.get(idRubrica);
	}
	
	public boolean delete(Integer idRubrica) {
		Rubrica rubrica = mappa.remove(idRubrica);
		return rubrica!=null;
	}

}
