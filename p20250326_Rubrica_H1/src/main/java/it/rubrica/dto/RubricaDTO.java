package it.rubrica.dto;


import java.util.ArrayList;
import java.util.List;



public class RubricaDTO {
	Integer id;
	String proprietario;
	Integer anno_creazione;
	
	List<ContattoDTO> contatti = new ArrayList<>();
	
	
	
	public RubricaDTO() {}

	public RubricaDTO(Integer id, String proprietario, Integer anno_creazione) {
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

	public List<ContattoDTO> getContatti() {
		return contatti;
	}

	public void setContatti(List<ContattoDTO> contatti) {
		this.contatti = contatti;
	}
	
	
	public void aggiungiContatto(ContattoDTO c) {
		contatti.add(c);
	}
	
	public ContattoDTO getContatto(Integer id) {
		return null;
	}

}

