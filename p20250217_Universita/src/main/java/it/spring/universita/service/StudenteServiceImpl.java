package it.spring.universita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.spring.universita.dao.StudenteDAO;
import it.spring.universita.dto.CognomeImmatricolazioneDTO;
import it.spring.universita.dto.CognomeNascitaDTO;
import it.spring.universita.dto.NomiStudentiDTO;
import it.spring.universita.dto.StudenteDTO;
import it.spring.universita.entity.Studente;
import it.spring.universita.utility.Conversion;
import it.spring.universita.utility.Queries;

@Service
public class StudenteServiceImpl implements StudenteService {
	
	@Autowired
	private StudenteDAO dao;
	
	public boolean createStudente(StudenteDTO dto) {
		return(dao.insert(Conversion.fromStudenteDTOToStudente(dto)));
	}
	
	public StudenteDTO searchStudente(int id) {
		Studente s = dao.selectByMatricola(id);
		if(s != null)
			return Conversion.fromStudenteToStudenteDTO(s);
		return null;
	}
	
	public List<StudenteDTO> viewAllStudente(){
		return Conversion.fromStudentiToStudentiDTO(dao.selectAll());
	}
	
	public StudenteDTO removeStudente(int id) {
		Studente s = dao.selectByMatricola(id);
		if(s != null) {
			dao.delete(id);
			return Conversion.fromStudenteToStudenteDTO(s);
		}
		return null;
	}
	
	public boolean editIndirizzoStudente(int id, String indirizzo) {
		Studente s = dao.selectByMatricola(id);
		if(s == null)
			return false;
		s.setIndirizzo(indirizzo);
		return true;
	}
	
	public NomiStudentiDTO viewAllNomiStudenti(){
		NomiStudentiDTO dto = new NomiStudentiDTO();
		dto.setNomi(Conversion.getNomiStudenti(dao.selectAll()));
		
		return dto;
	}
	
	public CognomeNascitaDTO getYoungerStudente() {
		return Queries.getYoungerStudente(dao.selectAll());
	}
	
	public CognomeImmatricolazioneDTO getOlderFreqStudente() {
		return Queries.getOlderFreqStudente(dao.selectAll());
	}
	
	

}
