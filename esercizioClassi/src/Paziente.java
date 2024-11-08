
public class Paziente extends Persona {
	private String illness;
	private Boolean codiceRosso;
	
	public Paziente(String nome, int eta, String illness, Boolean codiceRosso) {
		super(nome, eta);
		this.illness = illness;
		this.codiceRosso = codiceRosso;
	}
	
	public Paziente() {
		super();
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public Boolean getCodiceRosso() {
		return codiceRosso;
	}

	public void setCodiceRosso(Boolean codiceRosso) {
		this.codiceRosso = codiceRosso;
	}
	
	
	
}
