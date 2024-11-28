
public class Persona extends EssereVivente{
	String nome;
	int eta;
	
	
	public Persona(String nome, int eta) {
		this.nome = nome;
		this.eta = eta;
	}
	
	public Persona() {
		
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	
	
	@Override
	public String toString() {
		return "nome=" + nome + ", eta=" + eta;
	}

	@Override
	public void SetColoreOcchi() {
		this.coloreOcchi = "blu";
		
	}

	@Override
	public String GetColoreOcchi() {
		// TODO Auto-generated method stub
		return null;
	}

}
