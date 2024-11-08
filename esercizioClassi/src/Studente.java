
public class Studente extends Persona implements Comparable<Studente>{
	static public int studentiCreati = 0;
	private String matricola;

	public Studente(String nome, int eta, String matricola) {
		super(nome, eta);
		this.matricola = matricola;
		studentiCreati++;
	}
	public Studente() {
		
	}

	@Override
	public String toString() {
		return super.toString() + ", matricola=" + matricola + "\n";
	}
	
	//
	@Override
	public int compareTo(Studente o) {
		if(getNome().compareTo(o.getNome()) == 0){
			return ((Integer)getEta()).compareTo((Integer) o.eta);
		}
		return getNome().compareTo(o.getNome());
		
	}
}
