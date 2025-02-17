package p20250207_ESAME_Domanda1;

import java.util.Arrays;

public class Televisore extends Prodotto{
	private int pollici;

	protected Televisore(String id, String nome, String descrizione, Double prezzo, String[] negozi, int pollici) {
		super(id, nome, descrizione, prezzo, negozi);
		this.pollici = pollici;
	}

	public int getPollici() {
		return pollici;
	}

	public void setPollici(int pollici) {
		this.pollici = pollici;
	}

	@Override
	public String toString() {
		return "Televisore [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", prezzo=" + prezzo
				+ ", negozi=" + Arrays.toString(negozi) + ", pollici=" + pollici + "]";
	}
	
	
}
