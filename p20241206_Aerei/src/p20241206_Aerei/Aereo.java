package p20241206_Aerei;

public class Aereo {
	public String nome;
	public int capienza;
	public int posti_occupati;
	
	public Aereo() {
		this.nome = "a";
		this.capienza = 20;
		this.posti_occupati = 0;
	}

	public Aereo(String nome, int capienza) {
		super();
		this.nome = nome;
		this.capienza = capienza;
		this.posti_occupati = 0;
	}

	@Override
	public String toString() {
		return "{\n"+ nome + ":{nome:" + nome + ", capienza:" + capienza 
				+ ", posti_occupati:" + posti_occupati + "}\n}\n";
	}
	
	

}
