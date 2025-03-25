package it.studenti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.studenti.entity.Studente;

public interface StudenteDAO extends JpaRepository<Studente, String> {
	
	// qui ci sono già in eridità tutte le funzioni CRUD
	
	
	// query personalizzata
	@Query(nativeQuery = true, value="select * from studente where anno_immatricolazione > :annoImm")
	List<Studente> getGiovani(int annoImm);

}
