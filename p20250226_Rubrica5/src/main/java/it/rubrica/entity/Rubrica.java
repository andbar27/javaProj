package it.rubrica.entity;

import java.util.Map;
import java.util.TreeMap;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Rubrica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String proprietario;
	private Integer anno_creazione;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "rubrica")
    @MapKeyColumn(name = "map_key") // Colonna per la chiave nella tabella Contatto
	private Map<String, Contatto> contatti = new TreeMap<String, Contatto>();
	
	public Rubrica() {}

	public Rubrica(Integer id, String proprietario, Integer anno_creazione) {
		super();
		this.id = id;
		this.proprietario = proprietario;
		this.anno_creazione = anno_creazione;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public Integer getAnno_creazione() {
		return anno_creazione;
	}

	public void setAnno_creazione(Integer anno_creazione) {
		this.anno_creazione = anno_creazione;
	}

	public Map<String, Contatto> getContatti() {
		return contatti;
	}

	public void setContatti(Map<String, Contatto> contatti) {
		this.contatti = contatti;
	}

	public boolean addContatto(Contatto c) {
		String p = c.getNome() + '%' + c.getCognome();
		if(this.contatti.containsKey(p))
			throw new RuntimeException("id contatto già presente");
		this.contatti.put(p, c);
		return true;
	}
	
	public Contatto getContatto(String nome, String cognome) {
		String p = (nome + '%' + cognome);
		if(this.contatti.containsKey(p))
			return this.contatti.get(p);
		throw new RuntimeException("id contatto non presente");
	}

}
