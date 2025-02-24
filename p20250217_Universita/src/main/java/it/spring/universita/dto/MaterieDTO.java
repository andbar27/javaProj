package it.spring.universita.dto;

import java.util.List;

public class MaterieDTO {
	List<String> materie;
	
	public MaterieDTO() {}
	
	protected MaterieDTO(List<String> materie) {
		super();
		this.materie = materie;
	}

	public List<String> getMaterie() {
		return materie;
	}

	public void setMaterie(List<String> materie) {
		this.materie = materie;
	}

}
