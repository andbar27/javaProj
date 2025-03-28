package it.rubrica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Date;

@Entity
public class Contatto {
	@Id
	private Integer id;
	private String nome, cognome;
	private String numero;
	private String gruppo;
	private Date nascita;
	private Boolean preferito = false;
	
	
	public Contatto() {}


	public Contatto(Integer id, String nome, String cognome, String numero, String gruppo, Date nascita,
			Boolean preferito) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppo = gruppo;
		this.nascita = nascita;
		this.preferito = preferito;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Date getNascita() {
		return nascita;
	}


	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}


	public Boolean getPreferito() {
		return preferito;
	}


	public void setPreferito(Boolean preferito) {
		this.preferito = preferito;
	}

	

}
