package com.spring.primo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // indica a spring che dovrà istanziare e gestire questa classe
@RequestMapping(path="/calcola")
public class CalcolatriceController {
	
	// Non mettiamo nessun costruttore almeno c'è il costruttore di default
	// Se avessimo messo un costruttore il costruttore di default non ci sarebbe
	// e avremmo dovuto inizializzare noi un costruttore senza argomenti
	
	@GetMapping(path="/sum")
	public int somma(int a, int b) {
		return a + b;
	}
	
	@GetMapping(path="/divide")
	public int dividi(int a, int b) {
		return a / b;
	}
	
	@PostMapping(path="/sub")
	public int sottrazione(int a, int b) {
		return a - b;
	}
	
	@GetMapping(path="/mul")
	public int moltiplica(int a, int b) {
		return a * b;
	}
	
}
