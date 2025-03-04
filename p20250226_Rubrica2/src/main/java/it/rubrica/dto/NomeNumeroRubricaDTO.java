package it.rubrica.dto;

public class NomeNumeroRubricaDTO {
	private String nome_proprietario;
	private int len_contatti;
	
	public NomeNumeroRubricaDTO() {}

	public NomeNumeroRubricaDTO(String nome_proprietario, int len_contatti) {
		super();
		this.nome_proprietario = nome_proprietario;
		this.len_contatti = len_contatti;
	}

	
	public String getNome_proprietario() {
		return nome_proprietario;
	}

	public void setNome_proprietario(String nome_proprietario) {
		this.nome_proprietario = nome_proprietario;
	}

	public int getLen_contatti() {
		return len_contatti;
	}

	public void setLen_contatti(int len_contatti) {
		this.len_contatti = len_contatti;
	}

}
