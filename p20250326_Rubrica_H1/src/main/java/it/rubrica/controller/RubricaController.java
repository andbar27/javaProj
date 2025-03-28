package it.rubrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rubrica.dto.ContattoDTO;
import it.rubrica.dto.RubricaDTO;
import it.rubrica.service.RubricaService;

@RestController
@RequestMapping(path = "/rubriche")
public class RubricaController {
	
	@Autowired
	private RubricaService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean insertRubrica(@RequestBody RubricaDTO dto) {
		return service.insertRubrica(dto);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RubricaDTO selectRubrica(@PathVariable Integer id) {
		return service.selectRubrica(id);
	}
	
	@PostMapping(path = "/{id}/contatti", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean insertContatto(@PathVariable Integer id, @RequestBody ContattoDTO dto) {
		return service.insertContatto(id, dto);
	}

}
