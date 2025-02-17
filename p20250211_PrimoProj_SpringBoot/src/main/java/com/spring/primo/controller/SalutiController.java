package com.spring.primo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/saluto")
public class SalutiController {

	public SalutiController() {
		super();
		System.out.println("istanzia saluti");
	}
	
	@GetMapping(path="hw")
	public String hello() {
		return "hello world";
	}
	
	@GetMapping(path="pers")
	public String hello1(String s) {
		return "hello " + s + "!!";
	}
	
}
