package it.spring.magazzino.entity;

public class Prodotto {
	private int id;
	private String marca, modello, descrizione;
	private Double prezzo_consigliato, prezzo_massimo;
	private Integer n_pezzi;
	private String categoria;
	
	public Prodotto() {
		// TODO Auto-generated constructor stub
	}

	public Prodotto(int id, String marca, String modello, String descrizione, Double prezzo_consigliato,
			Double prezzo_massimo, Integer n_pezzi, String categoria) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.descrizione = descrizione;
		this.prezzo_consigliato = prezzo_consigliato;
		this.prezzo_massimo = prezzo_massimo;
		this.n_pezzi = n_pezzi;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Double getPrezzo_consigliato() {
		return prezzo_consigliato;
	}

	public void setPrezzo_consigliato(Double prezzo_consigliato) {
		this.prezzo_consigliato = prezzo_consigliato;
	}

	public Double getPrezzo_massimo() {
		return prezzo_massimo;
	}

	public void setPrezzo_massimo(Double prezzo_massimo) {
		this.prezzo_massimo = prezzo_massimo;
	}

	public Integer getN_pezzi() {
		return n_pezzi;
	}

	public void setN_pezzi(Integer n_pezzi) {
		this.n_pezzi = n_pezzi;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
}
