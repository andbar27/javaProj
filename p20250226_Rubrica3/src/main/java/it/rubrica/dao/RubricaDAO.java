package it.rubrica.dao;

import java.util.List;

import it.rubrica.entity.Contatto;
import it.rubrica.entity.Rubrica;

public interface RubricaDAO {
	
	boolean insert(Rubrica rubrica);
	
	List<Rubrica> selectAll();

	Rubrica selectById(Integer idRubrica);
	
	boolean delete(Integer idRubrica);
	
	Rubrica edit(Rubrica rubrica);
	
	boolean insertContatto(Contatto contatto, Integer idRubrica);
	
	boolean deleteContatto(String nome, String cognome, int idRubrica);
	
	Contatto editContatto(Contatto contatto, int idRubrica);

}
