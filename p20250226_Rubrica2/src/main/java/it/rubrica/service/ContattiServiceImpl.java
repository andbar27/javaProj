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

@Service
public class ContattiServiceImpl implements ContattiService {

	@Autowired
	private RubricaDAO dao;
	
	public void newContatto(int id, ContattoDTO c) {
		if(dao.selectById(id) != null)
			dao.selectById(id).addContatto(Conversion.fromContattoDTOToContatto(c));
	}
	
	public ContattoDTO selectContatto(int id, String nome, String cognome) {
		return Conversion.fromContattoToContattoDTO(dao.selectById(id).getContatto(nome, cognome));
	}

	public void editContatto(int id, ContattoDTO dto) {
		Contatto c = dao.selectById(id).getContatto(dto.getNome(), dto.getCognome());
		c.setNumero(dto.getNumero());
		c.setData_nascita(dto.getData_nascita());
		c.setGruppo(dto.getGruppo());
		c.setPreferito(dto.isPreferito());
	}
	
	public ContattoDTO removeContatto(int id, String nome, String cognome) {
		Rubrica r = dao.selectById(id);
		Contatto c = r.getContatto(nome, cognome);
		
		r.getContatti().remove((nome + cognome));
		return Conversion.fromContattoToContattoDTO(c);
	}
	
	public List<ContattoDTO> selectAllContatto(int id){
		return Conversion.fromContattiToContattiDTO(dao.selectById(id).getContatti().values());
	}
	
	public int sizeRubrica(int id) {
		return dao.selectById(id).getContatti().size();
	}
	
	public List<String> numeriContatti(int id){
		List<String> numeri = new ArrayList<String>();
		
		for(Contatto c : dao.selectById(id).getContatti().values())
			numeri.add(c.getNumero());
		
		return numeri;
	}
	
	public ContattoDTO selectByNumero(int id, String numero) {
		System.out.println("num: " + numero);
		for(Contatto c : dao.selectById(id).getContatti().values()) 
			if(c.getNumero().equals(numero))
				return Conversion.fromContattoToContattoDTO(c);
		
		throw new RuntimeException("numero non presente");
	}
	
	public List<NomeCognomeDTO> selectNomeCognomeByGruppo(int id, String gruppo){
		List<NomeCognomeDTO> ldto = new ArrayList<NomeCognomeDTO>();
		
		for(Contatto c : dao.selectById(id).getContatti().values()) 
			if(c.getGruppo().equals(gruppo))
				ldto.add(new NomeCognomeDTO(c.getNome(), c.getCognome()));
		
		return ldto;
	}
	
	public List<String> selectNumeriByGruppo(int id, String gruppo){
		List<String> numeri = new ArrayList<String>();
		
		for(Contatto c : dao.selectById(id).getContatti().values()) 
			if(c.getGruppo().equals(gruppo))
				numeri.add(c.getNumero());
		
		return numeri;
	}
	
	public List<String> removeByGruppo(int id, String gruppo){
		Rubrica r = dao.selectById(id);
		System.out.println("grup: " + gruppo);
		List<String> idC = new ArrayList<String>();
		
		for(Contatto c : r.getContatti().values()) 
			if(c.getGruppo().equals(gruppo)) 
				idC.add(c.getNome()+c.getCognome());
		
		for(String c : idC)
			r.getContatti().remove(c);
		
		return idC;
	}
	
	public void setPreferitoContatto(int id, String nome, String cognome) {
		Contatto c = dao.selectById(id).getContatto(nome, cognome);
		
		c.setPreferito(true);
	}
	
	public List<ContattoDTO> selectByPreferito(int id){
		List<ContattoDTO> ldto = new ArrayList<ContattoDTO>();
		
		for(Contatto c : dao.selectById(id).getContatti().values())
			if(c.isPreferito())
				ldto.add(Conversion.fromContattoToContattoDTO(c));
		
		return ldto;
	}
	
}
