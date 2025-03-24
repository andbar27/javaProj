package it.studenti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.studenti.entity.Studente;

public interface StudenteDAO extends JpaRepository<Studente, String> {
	
	// qui ci sono già in eridità tutte le funzioni CRUD:
	// 

}
