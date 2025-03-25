package it.studenti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.studenti.dto.StudenteDTO;
import it.studenti.service.StudenteService;

@RestController
@RequestMapping(path="/studenti")
public class StudenteController {
	
	@Autowired
	private StudenteService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean newStudente(@RequestBody StudenteDTO dto) {
		return service.immatricola(dto);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean editStudente(@RequestBody StudenteDTO dto) {
		return service.edit(dto);
	}
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudenteDTO selectStudenteById(@PathVariable String id) {
		return service.cerca(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudenteDTO> selectAllStudente(){
		return service.selectAll();
	}
	
	@DeleteMapping(path="/{id}")
	public boolean deleteStudente(@PathVariable String id) {
		return service.delete(id);
	}
	
	@GetMapping(path="/byAnnoImmatricolazione", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<StudenteDTO> byAnnoImmatricolazione(@RequestParam int annoImm){
		return service.getGiovani(annoImm);
	}

}
