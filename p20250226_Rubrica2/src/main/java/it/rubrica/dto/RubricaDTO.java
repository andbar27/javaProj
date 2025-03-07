package it.rubrica.dto;

import java.util.Map;
import java.util.TreeMap;


public class RubricaDTO {
	
	private int id;
	private String proprietario;
	private int anno_creazione;
	private Map<String, ContattoDTO> contatti = new TreeMap<String, ContattoDTO>();
	
	public RubricaDTO() {
		System.out.println("constructor");
	}

	public RubricaDTO(int id, String proprietario, int anno_creazione) {
		super();
		this.id = id;
		this.proprietario = proprietario;
		this.anno_creazione = anno_creazione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("set id");
		this.id = id;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public int getAnno_creazione() {
		return anno_creazione;
	}

	public void setAnno_creazione(int anno_creazione) {
		this.anno_creazione = anno_creazione;
	}

	public Map<String, ContattoDTO> getContatti() {
		return contatti;
	}

	public void setContatti(Map<String, ContattoDTO> contatti) {
		System.out.println("set");
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
