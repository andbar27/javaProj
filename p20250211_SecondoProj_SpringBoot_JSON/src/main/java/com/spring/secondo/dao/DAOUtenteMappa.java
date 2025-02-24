package com.spring.secondo.dao;

import java.util.List;

import com.spring.secondo.entity.Utente;

public interface DAOUtenteMappa {
	
	public boolean insert(Utente utente);
	
	public List<Utente> selectAll();

	public Utente selectById(Integer idUtente);
	
	public boolean delete(Integer idUtente);

}
