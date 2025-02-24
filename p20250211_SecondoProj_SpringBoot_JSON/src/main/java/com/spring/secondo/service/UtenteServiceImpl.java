package com.spring.secondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.secondo.dao.DAOUtenteMappa;
import com.spring.secondo.dto.ListaNC_LenDTO;
import com.spring.secondo.dto.NomeCognomeDTO;
import com.spring.secondo.dto.UtenteDto;
import com.spring.secondo.entity.Utente;
import com.spring.secondo.utility.Utility;

@Service
public class UtenteServiceImpl implements UtenteService {
	
	// è fuorviante perché DAOUtenteMappa è esso stesso la persistenza
	// invece dovrebbe essere solo un punto d'accesso
	// private DAOUtenteMappa dao = new DAOUtenteMappa();
	
	@Autowired	//Injection di spring
	private DAOUtenteMappa dao;
	
	public boolean registra(UtenteDto dto) {
		// trasformo dto in entity
		Utente entity = Utility.fromUtenteDtoToUtente(dto);
		
		// inserisco entinty attraverso il dao
		boolean response = dao.insert(entity);
		return response;
	}
	
	public UtenteDto cercaPerId(int id) {
		Utente entity = dao.selectById(id);
		
		if(entity != null)
			return Utility.fromUtenteToUtenteDto(entity);
		
		return null;
	}
	
	public List<UtenteDto> listaUtenti(){
		return Utility.fromUtentiToUtentiDto(dao.selectAll());
	}
	
	public UtenteDto rimuoviPerId(int id) {
		UtenteDto dto = this.cercaPerId(id);
		if(dto == null) 
			return null;
		
		dao.delete(id);
		return dto;
	}
	
	public boolean modPassword(int id, String pw) {
		Utente u = dao.selectById(id);
		if(u == null)
			return false;
		u.setPassword(pw);
		return true;
		
//		UtenteDto dto = this.rimuoviPerId(id);
//		if(dto == null)
//			return false;
//		
//		dto.setPassword(pw);
//		this.registra(dto);
//		return true;
	}
	
	public NomeCognomeDTO getNomeCognome(int id) {
		Utente u = dao.selectById(id);
		if(u == null)
			return null;
		
		return new NomeCognomeDTO(u.getNome(), u.getCognome());
	}
	
	public ListaNC_LenDTO getAllNomeCognome(){
		return new ListaNC_LenDTO(Utility.fromUtentiToNomiCognomiDTO(dao.selectAll()));
	}
}
