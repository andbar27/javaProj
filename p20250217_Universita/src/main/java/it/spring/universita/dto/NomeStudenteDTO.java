package it.spring.universita.dto;

public class NomeStudenteDTO {
	String nome;
	
	public NomeStudenteDTO() {
		// TODO Auto-generated constructor stub
	}

	public NomeStudenteDTO(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
