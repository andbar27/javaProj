package it.studenti.service;

import java.util.List;

import it.studenti.dto.StudenteDTO;

public interface StudenteService {
	
	boolean immatricola(StudenteDTO dto);
	
	StudenteDTO cerca(String matricola);
	
	List<StudenteDTO> selectAll();
	
	boolean delete(String matricola);

}
