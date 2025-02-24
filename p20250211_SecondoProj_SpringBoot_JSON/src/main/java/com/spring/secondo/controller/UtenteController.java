package com.spring.secondo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.secondo.dto.ListaNC_LenDTO;
import com.spring.secondo.dto.NomeCognomeDTO;
import com.spring.secondo.dto.UtenteDto;
import com.spring.secondo.service.UtenteService;

@RestController
@RequestMapping(path="/utenti")
public class UtenteController {
	
	@Autowired
	private UtenteService service;
	
	@PostMapping(path="/registra", consumes = "application/json")
	public boolean registra(@RequestBody UtenteDto dto) {
		return service.registra(dto);
	}
	
	@GetMapping(path="/cerca/{id}", produces = "application/json")
	public UtenteDto cercaPerId(@PathVariable int id) {
		return service.cercaPerId(id);
	}
	
	@GetMapping(path="/listaUtenti", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UtenteDto> listaUtenti(){
		return service.listaUtenti();
	}
	
	@GetMapping(path="/rimuovi/{id}", produces = "application/json")
	public UtenteDto rimuoviPerId(@PathVariable int id) {
		return service.rimuoviPerId(id);
	}
	
	@PostMapping(path="/modPass/{id}")
	public boolean modPW(@PathVariable int id, String pw) {
		return service.modPassword(id, pw);
	}
	
	@GetMapping(path="/nomeCognome/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public NomeCognomeDTO getNomeCognome(@PathVariable int id) {
		return service.getNomeCognome(id);
	}
	
	@GetMapping(path="/listaNomiCognomi", produces = MediaType.APPLICATION_JSON_VALUE)
	public ListaNC_LenDTO listaNomeCognome(){
		return service.getAllNomeCognome();
	}
}
