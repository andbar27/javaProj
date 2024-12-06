package p20241206_Aerei;

import java.util.LinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Compagnia {
	public String nome;
	public LinkedList<Aereo> lista_aerei;
	public LinkedList<Volo> lista_voli;
	
	public Compagnia(String nome) {
		super();
		this.nome = nome;
		this.lista_aerei = new LinkedList<Aereo>();
	}
	
	public Compagnia() {
		super();
		this.nome = "comp";
		this.lista_aerei = new LinkedList<Aereo>();
		this.lista_voli = new LinkedList<Volo>();
	}

	public Aereo creaAereo(String nome, int capienza) {
		Aereo a = new Aereo(nome, capienza);
		this.lista_aerei.add(a);
		return a;
	}
	
	public void eliminaAereo(String nome) {
		for(Aereo aereo : this.lista_aerei){
			if(aereo.nome == nome)
				lista_aerei.remove(aereo);
				return;
		}
	}

	public Volo creaVolo(Aereo a) {
		Volo v = new Volo(a);
		this.lista_voli.add(v);
		return v;
	}
	
	public void eliminaVolo(Volo v) {
		if(lista_voli.contains(v))
			lista_voli.remove(v);
	}
	
	

	@Override
	public String toString() {
		return "{\n" + nome + ":{nome:" + nome + ", lista_aerei:" 
		+ lista_aerei.toString() + ", lista_voli:" + lista_voli.toString() 
		+ "}\n}\n";
	}
	
	

		
}
