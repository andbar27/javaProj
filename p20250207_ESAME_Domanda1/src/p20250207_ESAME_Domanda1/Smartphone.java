package p20250207_ESAME_Domanda1;

import java.util.Arrays;

public class Smartphone extends Prodotto{
	private int ram;

	protected Smartphone(String id, String nome, String descrizione, Double prezzo, String[] negozi, int ram) {
		super(id, nome, descrizione, prezzo, negozi);
		this.ram = ram;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Smartphone [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", prezzo=" + prezzo
				+ ", negozi=" + Arrays.toString(negozi) + ", ram=" + ram + "]";
	}
	
	

}
