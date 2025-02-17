package it.spring.universita.dto;

public class CognomeImmatricolazioneDTO {
	String cognome;
	int anno_immatricolazione;
	public CognomeImmatricolazioneDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CognomeImmatricolazioneDTO(String cognome, int anno_immatricolazione) {
		super();
		this.cognome = cognome;
		this.anno_immatricolazione = anno_immatricolazione;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getAnno_immatricolazione() {
		return anno_immatricolazione;
	}
	public void setAnno_immatricolazione(int anno_immatricolazione) {
		this.anno_immatricolazione = anno_immatricolazione;
	}
	
	

}
