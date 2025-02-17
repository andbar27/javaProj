package it.spring.universita.service;

import java.util.List;

import it.spring.universita.dao.ProfessoreDAO;
import it.spring.universita.dto.ProfessoreDTO;
import it.spring.universita.entity.Professore;
import it.spring.universita.utility.Conversion;

public class ProfessoreService {
	
	private ProfessoreDAO dao = new ProfessoreDAO();
	
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

}
