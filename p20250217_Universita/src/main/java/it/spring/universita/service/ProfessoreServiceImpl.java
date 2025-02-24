package it.spring.universita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.spring.universita.dao.ProfessoreDAO;
import it.spring.universita.dto.MaterieDTO;
import it.spring.universita.dto.ProfessoreDTO;
import it.spring.universita.entity.Professore;
import it.spring.universita.utility.Conversion;
import it.spring.universita.utility.Queries;

@Service
public class ProfessoreServiceImpl implements ProfessoreService {
	
	@Autowired
	private ProfessoreDAO dao;
	
	public boolean createProfessore(ProfessoreDTO dto) {
		return(dao.insert(Conversion.fromProfessoreDTOToProfessore(dto)));
	}
	
	public ProfessoreDTO searchProfessore(int id) {
		Professore s = dao.selectById(id);
		if(s != null)
			return Conversion.fromProfessoreToProfessoreDTO(s);
		return null;
	}
	
	public List<ProfessoreDTO> viewAllProfessore(){
		return Conversion.fromProfessoriToProfessoriDTO(dao.selectAll());
	}
	
	public ProfessoreDTO removeProfessore(int id) {
		Professore s = dao.selectById(id);
		if(s != null) {
			dao.delete(id);
			return Conversion.fromProfessoreToProfessoreDTO(s);
		}
		return null;
	}
	
	public boolean editMateriaProfessore(int id, String materia) {
		Professore s = dao.selectById(id);
		if(s == null)
			return false;
		s.setMateria(materia);
		return true;
	}
	
	public List<ProfessoreDTO> viewAllProfessoreMateria(String materia){
		return(Queries.viewAllProfessoreMateria(dao.selectAll(), materia));
	}
	
	public List<ProfessoreDTO> viewAllProfessoreSort(){
		List<Professore> lp = dao.selectAll();
		lp.sort((p1, p2) -> p1.getCognome().compareTo(p2.getCognome()));
		return Conversion.fromProfessoriToProfessoriDTO(lp);
	}
	
	public MaterieDTO viewAllMateria() {
		return Queries.viewAllMateria(dao.selectAll());
	}

}
