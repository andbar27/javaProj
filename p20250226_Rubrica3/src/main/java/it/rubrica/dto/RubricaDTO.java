package it.rubrica.dto;

import java.util.Map;
import java.util.TreeMap;


public class RubricaDTO {
	
	private Integer id;
	private String proprietario;
	private Integer anno_creazione;
	private Map<String, ContattoDTO> contatti = new TreeMap<String, ContattoDTO>();
	
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

	public Map<String, ContattoDTO> getContatti() {
		return contatti;
	}

	public void setContatti(Map<String, ContattoDTO> contatti) {
		this.contatti = contatti;
	}

	public boolean addContatto(ContattoDTO c) {
		String p = (c.getNome() + c.getCognome());
		if(this.contatti.containsKey(p))
			throw new RuntimeException("id contatto già presente");
		this.contatti.put(p, c);
		return true;
	}

}
