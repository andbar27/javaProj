package it.spring.universita.dao;

import java.util.List;

import it.spring.universita.entity.Professore;

public interface ProfessoreDAO {
	
	public boolean insert(Professore professore);
	
	public List<Professore> selectAll();

	public Professore selectById(Integer idProfessore);
	
	public boolean delete(Integer idProfessore);

}
