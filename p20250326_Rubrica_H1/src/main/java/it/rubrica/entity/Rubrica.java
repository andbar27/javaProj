package it.rubrica.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Rubrica {
	@Id
	Integer id;
	String proprietario;
	Integer anno_creazione;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_Rubrica")
	List<Contatto> contatti = new ArrayList<>();
	
	
	
	public Rubrica() {}

	public Rubrica(Integer id, String proprietario, Integer anno_creazione) {
		super();
		this.id = id;
		this.proprietario = proprietario;
		this.anno_creazione = anno_creazione;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public Integer getAnno_creazione() {
		return anno_creazione;
	}

	public void setAnno_creazione(Integer anno_creazione) {
		this.anno_creazione = anno_creazione;
	}

	public List<Contatto> getContatti() {
		return contatti;
	}

	public void setContatti(List<Contatto> contatti) {
		this.contatti = contatti;
	}
	
	
	public void aggiungiContatto(Contatto c) {
		contatti.add(c);
	}
	
	public Contatto getContatto(Integer id) {
		return null;
	}

}
