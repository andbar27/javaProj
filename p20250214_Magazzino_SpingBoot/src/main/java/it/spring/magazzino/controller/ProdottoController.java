package it.spring.magazzino.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.spring.magazzino.dto.ProdottoDTO;
import it.spring.magazzino.dto.ProdottoNoIdDTO;
import it.spring.magazzino.dto.ReportDTO;
import it.spring.magazzino.service.ProdottoService;

@RestController
@RequestMapping(path="/prodotto")
public class ProdottoController {
	private ProdottoService service = new ProdottoService();
	
	@PostMapping(path="/caricaProdotto", consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean registraProdotto(@RequestBody ProdottoDTO dto) {
		return service.caricaProdotto(dto);
	}
	
	@GetMapping(path="/viewProd/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ProdottoDTO getProdById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@GetMapping(path="/viewAll", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ProdottoDTO> getAll(){
		return service.getAll();
	}
	
	@GetMapping(path="/viewAllNoId", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ProdottoNoIdDTO> getAllNoId(){
		return service.getAllNoId();
	}
	
	@GetMapping(path="/getReport", produces = MediaType.APPLICATION_JSON_VALUE)
	public ReportDTO getReport() {
		return service.getReport();
	}

}
