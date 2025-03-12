package it.rubrica.dto;


public class NomeAnnoRubricaDTO {
	private String nome_proprietario;
	private Integer data_creazione;
	
	public NomeAnnoRubricaDTO() {}

	public NomeAnnoRubricaDTO(String nome_proprietario, int data_creazione) {
		super();
		this.nome_proprietario = nome_proprietario;
		this.data_creazione = data_creazione;
	}

	public String getNome_proprietario() {
		return nome_proprietario;
	}

	public void setNome_proprietario(String nome_proprietario) {
		this.nome_proprietario = nome_proprietario;
	}

	public Integer getData_creazione() {
		return data_creazione;
	}

	public void setData_creazione(Integer data_creazione) {
		this.data_creazione = data_creazione;
	}
	
}
