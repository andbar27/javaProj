package p20241220_37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Mazzo {
	private List<Integer> carte;
	int n_semi;
	int n_simboli;
	String[] semi;

	public Mazzo(int n_semi, int n_simboli, String[] semi) {
		super();
		this.semi = semi;
		this.n_semi = semi.length;
		this.n_simboli = n_simboli;
		this.carte = new ArrayList<Integer>();
		creaMazzo(n_semi, n_simboli);
	}
	
	private void creaMazzo(int n_semi, int n_simboli) {
		for(int i=1; i<=n_semi*n_simboli; i++) {
			carte.add(i);
		}
		Collections.shuffle(carte);
	}
	
	public int interpretaSimboloCarta(Integer carta) {
		int temp = carta % n_simboli;
		if(temp == 0)
			temp = 10;
		return temp;
	}
	
	public String interpretaSemeCarta(Integer carta) {
		return semi[(carta-1) / n_simboli];
	}
	
	// Formato return: 7,Denara
	public String interpretaCarta(Integer carta) {
		return "" + interpretaSimboloCarta(carta) + "," + interpretaSemeCarta(carta);
	}
	
	public Integer pesca() {
		return carte.removeFirst();
	}
	
	public void mescola() {
		Collections.shuffle(carte);
	}

	@Override
	public String toString() {
		return "Mazzo [carte=" + carte + ",\n\nn_semi=" + n_semi + ", n_simboli=" + n_simboli + ", semi="
				+ Arrays.toString(semi) + "]";
	}
	
	
}
