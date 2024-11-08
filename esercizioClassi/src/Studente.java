
public class Studente extends Persona{
	String matricola;

	public Studente(String nome, int eta, String matricola) {
		super(nome, eta);
		this.matricola = matricola;
	}

	@Override
	public String toString() {
		return super.toString() + ", matricola=" + matricola;
	}

}
