package it.spring.universita.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.spring.universita.dto.ProfessoreDTO;
import it.spring.universita.service.ProfessoreService;

@RestController
@RequestMapping(path="/professore")
public class ProfessoreController {
	
	private ProfessoreService service = new ProfessoreService();
	
	@PostMapping(path="/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean createProfessore(@RequestBody ProfessoreDTO dto) {
		return service.createProfessore(dto);
	}
	
	@GetMapping(path="/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfessoreDTO searchProfessore(@PathVariable int id) {
		return service.searchProfessore(id);
	}
	
	@GetMapping(path="/viewAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProfessoreDTO> viewAllStudenti(){
		return service.viewAllProfessore();
	}
	
	@GetMapping(path="/remove/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfessoreDTO removeProfessore(@PathVariable int id) {
		return service.removeProfessore(id);
	}
	
	@GetMapping(path="/editMateria/{id}")
	public boolean editMateriaProfessore(@PathVariable int id, String materia) {
		return service.editMateriaProfessore(id, materia);
	}

}
