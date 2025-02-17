package com.spring.primo.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/date")
public class DataController {
	
	@GetMapping(path="/cur")
	public LocalDate oraCorrente() {
		return LocalDate.now();
	}
	
	@GetMapping(path="/yearday")
	public LocalDate getDay(int y, int d) {
		return LocalDate.ofYearDay(y, d);
	}

}
