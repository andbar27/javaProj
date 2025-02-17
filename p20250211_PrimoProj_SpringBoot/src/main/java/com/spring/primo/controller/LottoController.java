package com.spring.primo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path="")
public class LottoController {
	
	@GetMapping(path="/lotto")
	public List<Integer> lotto() {
		List<Integer> li = new ArrayList<Integer>();
		Random a = new Random();
		
		for(int i=0; i<5; i++) {
			Integer temp = a.nextInt(1, 90);
			while(li.contains(temp))
				temp = a.nextInt(1, 90);
			li.add(temp);
		}
		
		return li;
	}
	
}
