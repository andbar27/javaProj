package it.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Venditore {
	
	@Id
	private Integer id;
	private String nome, cognome, username, password, via, citta;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_Venditore")
	private List<Prodotto> prodotti = new ArrayList<>();
	
	public Venditore() {}

	public Venditore(Integer id, String nome, String cognome, String username, String password, String via,
			String citta) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.via = via;
		this.citta = citta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCittà(String citta) {
		this.citta = citta;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
	
	public void addProdotto(Prodotto p) {
		this.prodotti.add(p);
	}
	
	public Prodotto getProdotto(Integer idP) {
		for(Prodotto p : prodotti)
			if(p.getId().equals(idP))
				return p;
		
		return null;
	}

}
