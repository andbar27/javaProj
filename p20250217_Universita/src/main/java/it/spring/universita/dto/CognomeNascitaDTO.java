package it.spring.universita.dto;

public class CognomeNascitaDTO {
	String cognome;
	int anno_nascita;
	
	public CognomeNascitaDTO() {
		// TODO Auto-generated constructor stub
	}

	protected CognomeNascitaDTO(String cognome, int anno_nascita) {
		super();
		this.cognome = cognome;
		this.anno_nascita = anno_nascita;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getAnno_nascita() {
		return anno_nascita;
	}

	public void setAnno_nascita(int anno_nascita) {
		this.anno_nascita = anno_nascita;
	}
	
	

}
