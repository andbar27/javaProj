package it.rubrica.dto;

import java.util.ArrayList;
import java.util.List;

public class ElencoNomiRubricaDTO {
	List<String> nomi = new ArrayList<String>();
	Integer lenght = 0;
	
	public ElencoNomiRubricaDTO() {}

	public List<String> getNomi() {
		return nomi;
	}

	public void setNomi(List<String> nomi) {
		this.nomi = nomi;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(Integer lenght) {
		this.lenght = lenght;
	}
	
	public void addNome(String nome) {
		this.nomi.add(nome);
		this.lenght = this.nomi.size();
	}
}
