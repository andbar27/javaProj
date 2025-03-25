package it.impiegati.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Impiegato {
	
	@Id
	private Integer matricola;
	
	private String nome, cognome;
	private Double salario_mensile;
	
	
	public Impiegato() {}

	public Impiegato(Integer matricola, String nome, String cognome, Double salario_mensile) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.salario_mensile = salario_mensile;
	}

	
	public Integer getMatricola() {
		return matricola;
	}

	public void setMatricola(Integer matricola) {
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

	public Double getSalario_mensile() {
		return salario_mensile;
	}

	public void setSalario_mensile(Double salario_mensile) {
		this.salario_mensile = salario_mensile;
	}

}
