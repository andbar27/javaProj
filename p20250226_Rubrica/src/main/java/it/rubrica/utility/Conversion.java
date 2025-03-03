package it.rubrica.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.rubrica.dto.ContattoDTO;
import it.rubrica.dto.RubricaDTO;
import it.rubrica.entity.Contatto;
import it.rubrica.entity.Rubrica;

public class Conversion {
	
	public static ContattoDTO fromContattoToContattoDTO(Contatto c) {
		return new ContattoDTO(c.getNome(), c.getCognome(), c.getNumero(), c.getGruppo(), c.getData_nascita(), c.isPreferito());
	}
	
	public static Contatto fromContattoDTOToContatto(ContattoDTO c) {
		return new Contatto(c.getNome(), c.getCognome(), c.getNumero(), c.getGruppo(), c.getData_nascita(), c.isPreferito());
	}
	
	public static List<ContattoDTO> fromContattiToContattiDTO(Collection<Contatto> lc){
		List<ContattoDTO> ldto = new ArrayList<ContattoDTO>();
		
		for(Contatto c : lc) 
			ldto.add(fromContattoToContattoDTO(c));
		
		return ldto;
	}
	
	public static RubricaDTO fromRubricaToRubricaDTO(Rubrica r) {
		RubricaDTO dto = new RubricaDTO(r.getId(), r.getProprietario(), r.getAnno_creazione());
		
		for(Contatto c : r.getContatti().values()) 
			dto.addContatto(fromContattoToContattoDTO(c));
		
		return dto;
	}
	
	public static List<RubricaDTO> fromRubricheToRubricheDTO(List<Rubrica> lr){
		List<RubricaDTO> ldto = new ArrayList<RubricaDTO>();
		
		for(Rubrica r : lr) 
			ldto.add(fromRubricaToRubricaDTO(r));
		
		return ldto;
	}

}
