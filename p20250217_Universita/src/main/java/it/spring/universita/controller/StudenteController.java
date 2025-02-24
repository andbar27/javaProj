package it.spring.universita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.spring.universita.dto.CognomeImmatricolazioneDTO;
import it.spring.universita.dto.CognomeNascitaDTO;
import it.spring.universita.dto.NomiStudentiDTO;
import it.spring.universita.dto.StudenteDTO;
import it.spring.universita.service.StudenteService;

@RestController
@RequestMapping(path="/studente")
public class StudenteController {
	
	@Autowired
	private StudenteService service;
	
	@PostMapping(path="/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean createStudente(@RequestBody StudenteDTO dto) {
		return service.createStudente(dto);
	}
	
	@GetMapping(path="/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudenteDTO searchStudente(@PathVariable int id) {
		return service.searchStudente(id);
	}
	
	@GetMapping(path="/viewAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudenteDTO> viewAllStudenti(){
		return service.viewAllStudente();
	}
	
	@GetMapping(path="/remove/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudenteDTO removeStudente(@PathVariable int id) {
		return service.removeStudente(id);
	}
	
	@GetMapping(path="/editIndirizzo/{id}")
	public boolean editIndirizzoStudente(@PathVariable int id, String indirizzo) {
		return service.editIndirizzoStudente(id, indirizzo);
	}
	
	@GetMapping(path="/viewAllNomi", produces = MediaType.APPLICATION_JSON_VALUE)
	public NomiStudentiDTO viewAllNomiStudenti(){
		return service.viewAllNomiStudenti();
	}
	
	@GetMapping(path="/getYounger", produces = MediaType.APPLICATION_JSON_VALUE)
	public CognomeNascitaDTO getYoungerStudente() {
		return service.getYoungerStudente();
	}
	
	@GetMapping(path="/getOlderFreq", produces = MediaType.APPLICATION_JSON_VALUE)
	public CognomeImmatricolazioneDTO getOlderFreqStudente() {
		return service.getOlderFreqStudente();
	}
	
}
