
public class Paziente extends Persona implements Specs{
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

	@Override
	public String GetVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetDate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
