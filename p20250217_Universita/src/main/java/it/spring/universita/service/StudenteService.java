package it.spring.universita.service;

import java.util.List;

import it.spring.universita.dto.CognomeImmatricolazioneDTO;
import it.spring.universita.dto.CognomeNascitaDTO;
import it.spring.universita.dto.NomiStudentiDTO;
import it.spring.universita.dto.StudenteDTO;

public interface StudenteService {
	
	public boolean createStudente(StudenteDTO dto);
	
	public StudenteDTO searchStudente(int id);
	
	public List<StudenteDTO> viewAllStudente();
	
	public StudenteDTO removeStudente(int id);
	
	public boolean editIndirizzoStudente(int id, String indirizzo);
	
	public NomiStudentiDTO viewAllNomiStudenti();
	
	public CognomeNascitaDTO getYoungerStudente();
	
	public CognomeImmatricolazioneDTO getOlderFreqStudente();
}
