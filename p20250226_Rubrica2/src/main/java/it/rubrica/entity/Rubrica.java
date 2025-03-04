package it.rubrica.entity;

import java.util.Map;
import java.util.TreeMap;


public class Rubrica {
	private int id;
	private String proprietario;
	private int anno_creazione;
	private Map<String, Contatto> contatti = new TreeMap<String, Contatto>();
	
	public Rubrica() {}

	public Rubrica(int id, String proprietario, int anno_creazione) {
		super();
		this.id = id;
		this.proprietario = proprietario;
		this.anno_creazione = anno_creazione;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Map<String, Contatto> getContatti() {
		return contatti;
	}

	public void setContatti(Map<String, Contatto> contatti) {
		this.contatti = contatti;
	}

	public boolean addContatto(Contatto c) {
		String p = (c.getNome() + c.getCognome());
		if(this.contatti.containsKey(p))
			return false;
		this.contatti.put(p, c);
		return true;
	}
	
	public Contatto getContatto(String nome, String cognome) {
		String p = (nome + cognome);
		if(this.contatti.containsKey(p))
			return this.contatti.get(p);
		return null;
	}

}
