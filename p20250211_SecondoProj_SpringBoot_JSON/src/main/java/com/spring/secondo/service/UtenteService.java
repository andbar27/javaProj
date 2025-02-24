package com.spring.secondo.service;

import java.util.List;

import com.spring.secondo.dto.ListaNC_LenDTO;
import com.spring.secondo.dto.NomeCognomeDTO;
import com.spring.secondo.dto.UtenteDto;

public interface UtenteService {
	
	public boolean registra(UtenteDto dto);
	
	public UtenteDto cercaPerId(int id);
	
	public List<UtenteDto> listaUtenti();
	
	public UtenteDto rimuoviPerId(int id);
	
	public boolean modPassword(int id, String pw);
	
	public NomeCognomeDTO getNomeCognome(int id);
	
	public ListaNC_LenDTO getAllNomeCognome();

}
