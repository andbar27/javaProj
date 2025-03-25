package it.impiegati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.impiegati.service.ImpiegatoService;
import it.impiegati.dto.ErroreDTO;
import it.impiegati.dto.ImpiegatoDTO;
import it.impiegati.dto.NomeCognomeDTO;

@RestController
@RequestMapping(path="/impiegati")
public class ImpiegatoController {
	
	@Autowired
	private ImpiegatoService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean insertImpiegato(@RequestBody ImpiegatoDTO dto) {
		return service.insertImpiegato(dto);
	}
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ImpiegatoDTO selectImpiegato(@PathVariable Integer id) {
		return service.selectImpiegato(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ImpiegatoDTO> selectAllImpiegato(){
		return service.selectAllImpiegato();
	}
	
	@DeleteMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ImpiegatoDTO deleteImpiegato(@PathVariable Integer id) {
		return service.deleteImpiegato(id);
	}
	
	@PatchMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ImpiegatoDTO updateSalarioImpiegato(@PathVariable Integer id, Double salario) {
		return service.updateSalarioImpiegato(id, salario);
	}
	
	@DeleteMapping(path="/{id}/nc", produces = MediaType.APPLICATION_JSON_VALUE)
	public NomeCognomeDTO deleteImpiegatoNC(@PathVariable Integer id) {
		return service.deleteImpiegatoNC(id);
	}
	
	@GetMapping(path="/nc", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<NomeCognomeDTO> selectAllImpiegatoNC(){
		return service.selectAllImpiegatoNC();
	}
	
	@GetMapping(path="/salario", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ImpiegatoDTO> selectWhereSalarioGT(Double salario){
		return service.selectWhereSalarioGT(salario);
	}
	
	@GetMapping(path="/byCognome", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ImpiegatoDTO> selectAllImpiegatoOrderByName(){
		return service.selectAllImpiegatoOrderByName();
	}
	
	@GetMapping(path="/bySalario", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ImpiegatoDTO> selectAllImpiegatoOrderBySalary(){
		return service.selectAllImpiegatoOrderBySalary();
	}
	
	
	
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> handler(RuntimeException exc){
		ErroreDTO err = new ErroreDTO(exc.getMessage());
		
		ResponseEntity<ErroreDTO> resp = new ResponseEntity<ErroreDTO>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		return resp;
	}
}
