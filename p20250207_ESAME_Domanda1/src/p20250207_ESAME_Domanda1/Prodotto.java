package p20250207_ESAME_Domanda1;

import java.util.Arrays;

public class Prodotto {
	String id;
	String nome;
	String descrizione;
	Double prezzo;
	String[] negozi;
	
	
	public Prodotto(String id, String nome, String descrizione, Double prezzo, String[] negozi) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.negozi = negozi;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}


	public String[] getNegozi() {
		return negozi;
	}


	public void setNegozi(String[] negozi) {
		this.negozi = negozi;
	}


	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", prezzo=" + prezzo
				+ ", negozi=" + Arrays.toString(negozi) + "]";
	}
	
	
}
