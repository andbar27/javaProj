package it.spring.magazzino.dto;

import java.util.List;
import java.util.Map;

public class ReportDTO {
	List<String> descrizioni;
	int n_pezzi, n_notDisponibili;
	Double media_prezzi;
	List<String> prodotti_notDisponibili;
	Map<String, List<Integer>> id_per_categoria;
	
	public ReportDTO() {
		// TODO Auto-generated constructor stub
	}

	protected ReportDTO(List<String> descrizioni, int n_pezzi, int n_notDisponibili, Double media_prezzi,
			List<String> prodotti_notDisponibili, Map<String, List<Integer>> id_per_categoria) {
		super();
		this.descrizioni = descrizioni;
		this.n_pezzi = n_pezzi;
		this.n_notDisponibili = n_notDisponibili;
		this.media_prezzi = media_prezzi;
		this.prodotti_notDisponibili = prodotti_notDisponibili;
		this.id_per_categoria = id_per_categoria;
	}

	public List<String> getDescrizioni() {
		return descrizioni;
	}

	public void setDescrizioni(List<String> descrizioni) {
		this.descrizioni = descrizioni;
	}

	public int getN_pezzi() {
		return n_pezzi;
	}

	public void setN_pezzi(int n_pezzi) {
		this.n_pezzi = n_pezzi;
	}

	public int getN_notDisponibili() {
		return n_notDisponibili;
	}

	public void setN_notDisponibili(int n_notDisponibili) {
		this.n_notDisponibili = n_notDisponibili;
	}

	public Double getMedia_prezzi() {
		return media_prezzi;
	}

	public void setMedia_prezzi(Double media_prezzi) {
		this.media_prezzi = media_prezzi;
	}

	public List<String> getProdotti_notDisponibili() {
		return prodotti_notDisponibili;
	}

	public void setProdotti_notDisponibili(List<String> prodotti_notDisponibili) {
		this.prodotti_notDisponibili = prodotti_notDisponibili;
	}

	public Map<String, List<Integer>> getId_per_categoria() {
		return id_per_categoria;
	}

	public void setId_per_categoria(Map<String, List<Integer>> id_per_categoria) {
		this.id_per_categoria = id_per_categoria;
	}
	
}
