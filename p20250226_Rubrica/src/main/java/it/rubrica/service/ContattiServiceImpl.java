package it.rubrica.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rubrica.dao.RubricaDAO;
import it.rubrica.dto.ContattoDTO;
import it.rubrica.dto.NomeCognomeDTO;
import it.rubrica.entity.Contatto;
import it.rubrica.entity.Rubrica;
import it.rubrica.utility.Conversion;
import it.rubrica.entity.Pair;

@Service
public class ContattiServiceImpl implements ContattiService {

	@Autowired
	private RubricaDAO dao;
	
	public boolean newContatto(int id, ContattoDTO c) {
		if(dao.selectById(id) == null) return false; 
		return dao.selectById(id).addContatto(Conversion.fromContattoDTOToContatto(c));
	}
	
	public ContattoDTO selectContatto(int id, String nome, String cognome) {
		return Conversion.fromContattoToContattoDTO(dao.selectById(id).getContatto(nome, cognome));
	}

	public boolean editContatto(int id, ContattoDTO dto) {
		Contatto c = dao.selectById(id).getContatto(dto.getNome(), dto.getCognome());
		if(c == null) return false;
		
		c.setNumero(dto.getNumero());
		c.setData_nascita(dto.getData_nascita());
		c.setGruppo(dto.getGruppo());
		c.setPreferito(dto.isPreferito());
		return true;
	}
	
	public ContattoDTO removeContatto(int id, String nome, String cognome) {
		Rubrica r = dao.selectById(id);
		Contatto c =r.getContatto(nome, cognome);
		
		if(c != null)
			r.getContatti().remove(new Pair(nome,cognome));
		
		return Conversion.fromContattoToContattoDTO(c);
	}
	
	public List<ContattoDTO> selectAllContatto(int id){
		return Conversion.fromContattiToContattiDTO(dao.selectById(id).getContatti().values());
	}
	
	public int sizeRubrica(int id) {
		Rubrica r = dao.selectById(id);
		if(r == null) return 0;
		return dao.selectById(id).getContatti().size();
	}
	
	public List<String> numeriContatti(int id){
		List<String> numeri = new ArrayList<String>();
		
		for(Contatto c :dao.selectById(id).getContatti().values())
			numeri.add(c.getNumero());
		
		return numeri;
	}
	
	public ContattoDTO selectByNumero(int id, String numero) {
		Rubrica r = dao.selectById(id);
		
		for(Contatto c : r.getContatti().values()) 
			if(c.getNumero() == numero)
				return Conversion.fromContattoToContattoDTO(c);
		
		return null;
	}
	
	public List<NomeCognomeDTO> selectNomeCognomeByGruppo(int id, String gruppo){
		Rubrica r = dao.selectById(id);
		List<NomeCognomeDTO> ldto = new ArrayList<NomeCognomeDTO>();
		
		for(Contatto c : r.getContatti().values()) 
			if(c.getGruppo() == gruppo)
				ldto.add(new NomeCognomeDTO(c.getNome(), c.getCognome()));
		
		return ldto;
	}
	
	public List<String> selectNumeriByGruppo(int id, String gruppo){
		Rubrica r = dao.selectById(id);
		List<String> numeri = new ArrayList<String>();
		
		for(Contatto c : r.getContatti().values()) 
			if(c.getGruppo() == gruppo)
				numeri.add(c.getNumero());
		
		return numeri;
	}
	
	public List<String> removeByGruppo(int id, String gruppo){
		Rubrica r = dao.selectById(id);
		List<String> numeri = new ArrayList<String>();
		
		for(Contatto c : r.getContatti().values()) 
			if(c.getGruppo() == gruppo) {
				numeri.add(c.getNumero());
				r.getContatti().remove(new Pair(c.getNome(), c.getCognome()));
			}
		
		return numeri;
	}
	
	public boolean setPreferitoContatto(int id, String nome, String cognome) {
		Contatto c = dao.selectById(id).getContatto(nome, cognome);
		if(c == null)
			return false;
		c.setPreferito(true);
		return true;
	}
	
	public List<ContattoDTO> selectByPreferito(int id){
		List<ContattoDTO> ldto = new ArrayList<ContattoDTO>();
		
		for(Contatto c : dao.selectById(id).getContatti().values())
			if(c.isPreferito())
				ldto.add(Conversion.fromContattoToContattoDTO(c));
		
		return ldto;
	}
	
}
