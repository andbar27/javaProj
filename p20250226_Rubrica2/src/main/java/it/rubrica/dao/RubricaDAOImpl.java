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
			throw new RuntimeException("id rubrica già presente");
		
		mappa.put(rubrica.getId(), rubrica);
		return true;
	}
	
	public List<Rubrica> selectAll(){
		return new ArrayList<Rubrica>(mappa.values());
	}

	public Rubrica selectById(Integer idRubrica) {
		if(!mappa.containsKey(idRubrica))
			throw new RuntimeException("id rubrica non presente");
		return mappa.get(idRubrica);
	}
	
	public boolean delete(Integer idRubrica) {
		if(!mappa.containsKey(idRubrica))
			throw new RuntimeException("id rubrica non presente");
		Rubrica rubrica = mappa.remove(idRubrica);
		return rubrica != null;
	}

}
