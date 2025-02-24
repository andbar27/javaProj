package it.spring.universita.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import it.spring.universita.entity.Studente;



@Repository
public class StudenteDAOImpl implements StudenteDAO {

	private Map<Integer, Studente> mappa = new HashMap<>();

	public boolean insert(Studente studente) {
		if(mappa.containsKey(studente.getMatricola()))
			return false;
		
		mappa.put(studente.getMatricola(), studente);
		return true;
	}
	
	public List<Studente> selectAll(){
		return new ArrayList<Studente>(mappa.values());
	}

	public Studente selectByMatricola(Integer idStudente) {
		return mappa.get(idStudente);
	}
	
	public boolean delete(Integer idStudente) {
		Studente studente = mappa.remove(idStudente);
		return studente!=null;
	}
	
	

}


