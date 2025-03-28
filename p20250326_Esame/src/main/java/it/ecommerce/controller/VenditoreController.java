package it.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.ecommerce.dto.ProdottoDTO;
import it.ecommerce.dto.ProfiloVenditoreDTO;
import it.ecommerce.dto.VenditoreDTO;
import it.ecommerce.service.VenditoreService;
import it.ecommerce.dto.ErroreDTO;
import it.ecommerce.dto.PasswordDTO;

@RestController
@RequestMapping(path="/venditori")
public class VenditoreController {
	
	@Autowired
	private VenditoreService service;
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean insertVenditore(@RequestBody VenditoreDTO dto) {
		return service.insertVenditore(dto);
	}
	
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public VenditoreDTO selectVenditore(@PathVariable Integer id) {
		return service.selectVenditore(id);
	}
	
	
	@GetMapping(path="/profili/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfiloVenditoreDTO selectProfiloVenditore(@PathVariable Integer id) {
		return service.selectProfiloVenditore(id);
	}
	
	
	@PatchMapping(path="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public VenditoreDTO patchPasswordVenditore(@PathVariable Integer id, @RequestBody PasswordDTO password) {
		return service.patchPasswordVenditore(id, password.getPassword());
	}
	
	
	@PostMapping(path="/{idV}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean insertProdotto(@PathVariable Integer idV, @RequestBody ProdottoDTO dtoP) {
		return service.insertProdotto(idV, dtoP);
	}
	
	
	@PatchMapping(path="/{idV}/{idP}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProdottoDTO patchQuantitaProdotto(@PathVariable Integer idV, @PathVariable Integer idP, Integer quantita) {
		return service.patchQuantitaProdotto(idV, idP, quantita);
	}
	
	
	
	
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> handler(RuntimeException exc){
		ErroreDTO err = new ErroreDTO(exc.getMessage());
		
		ResponseEntity<ErroreDTO> resp = new ResponseEntity<ErroreDTO>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		return resp;
	}


}
