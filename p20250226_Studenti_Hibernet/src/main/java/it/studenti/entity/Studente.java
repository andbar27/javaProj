package it.studenti.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Studente {
	
	@Id
	private String matricola;
	
	private String nome;
	private String cognome;
	private Integer annoImmatricolazione;
	
	
	public Studente() {}

	
	public Studente(String matricola, String nome, String cognome, Integer annoImmatricolazione) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.annoImmatricolazione = annoImmatricolazione;
	}



	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
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

	public Integer getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}

	public void setAnnoImmatricolazione(Integer annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}
	
}
