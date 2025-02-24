package it.spring.universita.service;

import java.util.List;

import it.spring.universita.dto.MaterieDTO;
import it.spring.universita.dto.ProfessoreDTO;

public interface ProfessoreService {
	
	public boolean createProfessore(ProfessoreDTO dto);
	
	public ProfessoreDTO searchProfessore(int id);
	
	public List<ProfessoreDTO> viewAllProfessore();
	
	public ProfessoreDTO removeProfessore(int id);
	
	public boolean editMateriaProfessore(int id, String materia);
	
	public List<ProfessoreDTO> viewAllProfessoreMateria(String materia);
	
	public List<ProfessoreDTO> viewAllProfessoreSort();
	
	public MaterieDTO viewAllMateria();

}
