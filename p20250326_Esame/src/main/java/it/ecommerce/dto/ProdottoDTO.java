package it.ecommerce.dto;

public class ProdottoDTO {
	
	private Integer id;
	private String descrizione;
	private Integer quantita;
	private Double prezzo;
	private Integer sconto; //0->100%
	private String categoria;
	
	public ProdottoDTO() {}

	public ProdottoDTO(Integer id, String descrizione, Integer quantita, Double prezzo, Integer sconto, String categoria) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.quantita = quantita;
		this.prezzo = prezzo;
		this.sconto = sconto;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getSconto() {
		return sconto;
	}

	public void setSconto(Integer sconto) {
		this.sconto = sconto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
