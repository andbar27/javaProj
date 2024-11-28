
public class Persona {
	private String nome;
	private String cognome;
	
	public Persona(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}
	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + "]";
	}
	public String getNome() {
		return nome;
	}
	public Persona() {
		super();
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

}
