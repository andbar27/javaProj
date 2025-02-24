package it.spring.universita.dto;

import java.util.List;

public class NomiStudentiDTO {
	List<String> nomi;
	
	public NomiStudentiDTO() {
		// TODO Auto-generated constructor stub
	}

	protected NomiStudentiDTO(List<String> nomi) {
		super();
		this.nomi = nomi;
	}

	public List<String> getNomi() {
		return nomi;
	}

	public void setNomi(List<String> nomi) {
		this.nomi = nomi;
	}

}
