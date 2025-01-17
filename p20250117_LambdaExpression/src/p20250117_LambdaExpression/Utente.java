package p20250117_LambdaExpression;

public class Utente {
	private String nome;
	private String cognome;
	private int eta;
	private String citta;
	private String boh;
	protected Utente(String nome, String cognome, int eta, String citta, String boh) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.citta = citta;
		this.boh = boh;
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
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getBoh() {
		return boh;
	}
	public void setBoh(String boh) {
		this.boh = boh;
	}
	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", citta=" + citta + ", boh=" + boh
				+ "]";
	}
	
	

}
