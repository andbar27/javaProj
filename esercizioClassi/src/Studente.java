
public class Studente extends Persona implements Comparable<Studente>{
	static public int studentiCreati = 0;
	private String matricola;
	private String corso;
	private int annoDiFrequenza;

	public Studente(String nome, int eta, String matricola, String corso, int annoDiFrequenza) {
		super(nome, eta);
		this.matricola = matricola;
		this.corso = corso;
		this.annoDiFrequenza = annoDiFrequenza;
		studentiCreati++;
	}
	
	
	public Studente() {
		
	}

	
	
	
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getCorso() {
		return corso;
	}
	public void setCorso(String corso) {
		this.corso = corso;
	}
	public int getAnnoDiFrequenza() {
		return annoDiFrequenza;
	}
	public void setAnnoDiFrequenza(int annoDiFrequenza) {
		this.annoDiFrequenza = annoDiFrequenza;
	}
	
	@Override
	public int compareTo(Studente o) {
		int res = this.getNome().compareTo(o.getNome());
		if(res == 0){
			res = ((Integer)getEta()).compareTo((Integer) o.eta);
			if (res == 0) {
				res = this.getCorso().compareTo(o.getCorso());
				if (res == 0) {
					res = ((Integer)this.getAnnoDiFrequenza()).compareTo(o.getAnnoDiFrequenza());
				}
			} 			
		}
		return res;
		
	}
	
	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", corso=" + corso + ", annoDiFrequenza=" + annoDiFrequenza
				+ ", nome=" + nome + ", eta=" + eta  + "]";
	}
	
	
}
