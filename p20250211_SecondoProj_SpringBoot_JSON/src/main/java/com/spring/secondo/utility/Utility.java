package com.spring.secondo.utility;

import java.util.ArrayList;
import java.util.List;

import com.spring.secondo.dto.NomeCognomeDTO;
import com.spring.secondo.dto.UtenteDto;
import com.spring.secondo.entity.Utente;

public class Utility {
	
	public static Utente fromUtenteDtoToUtente(UtenteDto dto) {
		return new Utente(dto.getId(), dto.getNome(), dto.getCognome(), 
				dto.getUsername(), dto.getPassword());
	}
	
	public static UtenteDto fromUtenteToUtenteDto(Utente u) {
		return new UtenteDto(u.getId(), u.getNome(), u.getCognome(), 
				u.getUsername(), u.getPassword());
	}
	
	public static List<UtenteDto> fromUtentiToUtentiDto(List<Utente> lu){
		List<UtenteDto> ldto = new ArrayList<UtenteDto>();
		for(Utente u : lu) {
			ldto.add(Utility.fromUtenteToUtenteDto(u));
		}
		return ldto;
	}
	
	public static NomeCognomeDTO fromUtenteToNomeCognomeDTO(Utente u) {
		return new NomeCognomeDTO(u.getNome(), u.getCognome());
	}
	
	public static List<NomeCognomeDTO> fromUtentiToNomiCognomiDTO(List<Utente> lu){
		List<NomeCognomeDTO> ldto = new ArrayList<NomeCognomeDTO>();
		for(Utente u : lu) {
			ldto.add(Utility.fromUtenteToNomeCognomeDTO(u));
		}
		return ldto;
	}

}
