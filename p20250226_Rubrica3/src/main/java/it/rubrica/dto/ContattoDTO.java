package it.rubrica.dto;

import java.sql.Date;

public class ContattoDTO {
	
	private String nome, cognome, numero, gruppo = "default";
	private Date data_nascita;
	private Boolean preferito = false;
	
	public ContattoDTO() {}

	public ContattoDTO(String nome, String cognome, String numero, String gruppo, Date data_nascita, Boolean preferito) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppo = gruppo;
		this.data_nascita = data_nascita;
		this.preferito = preferito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getGruppo() {
		return gruppo;
	}

	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}

	public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public Boolean isPreferito() {
		return preferito;
	}

	public void setPreferito(Boolean preferito) {
		this.preferito = preferito;
	}

}
