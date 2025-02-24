package it.spring.universita.dao;

import java.util.List;

import it.spring.universita.entity.Studente;

public interface StudenteDAO {
	
	public boolean insert(Studente studente);
	
	public List<Studente> selectAll();

	public Studente selectByMatricola(Integer idStudente);
	
	public boolean delete(Integer idStudente);

}
