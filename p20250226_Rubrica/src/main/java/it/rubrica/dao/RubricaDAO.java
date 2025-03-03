package it.rubrica.dao;

import java.util.List;

import it.rubrica.entity.Rubrica;

public interface RubricaDAO {
	
	public boolean insert(Rubrica rubrica);
	
	public List<Rubrica> selectAll();

	public Rubrica selectById(Integer idRubrica);
	
	public boolean delete(Integer idRubrica);

}
