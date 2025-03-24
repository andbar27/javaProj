package it.studenti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.studenti.dao.StudenteDAO;
import it.studenti.dto.StudenteDTO;
import it.studenti.utility.Conversion;

@Service
@Transactional
public class StudenteServiceImpl implements StudenteService {
	
	@Autowired
	private StudenteDAO dao;

	@Override
	public boolean immatricola(StudenteDTO dto) {
		if(dao.findById(dto.getMatricola()).isPresent())
			return false;
		
		return dao.save(Conversion.fromStudenteDTOToStudente(dto)) != null;
	}

	@Override
	public StudenteDTO cerca(String matricola) {
		if(!dao.findById(matricola).isPresent())
			return null;
		
		return Conversion.fromStudenteToStudenteDTO(dao.findById(matricola).get());
	}
	
	public List<StudenteDTO> selectAll(){
		return Conversion.fromStudentiToStudentiDTO(dao.findAll());
	}
	
	public boolean delete(String matricola) {
		if(!dao.findById(matricola).isPresent())
			return false;
		
		dao.deleteById(matricola);
		return true;
	}

}
