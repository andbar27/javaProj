package it.rubrica.utility;

import java.util.List;
import java.util.stream.Collectors;

import it.rubrica.dto.ContattoDTO;
import it.rubrica.dto.RubricaDTO;
import it.rubrica.entity.Contatto;
import it.rubrica.entity.Rubrica;

public class Conversion {
	
	public static Contatto fromContattoDTOToContatto(ContattoDTO dto) {
		return new Contatto(dto.getId(), dto.getNome(), dto.getCognome(), dto.getNumero(), dto.getGruppo(), dto.getNascita(), dto.getPreferito());
	}
	
	public static ContattoDTO fromContattoToContattoDTO(Contatto c) {
		return new ContattoDTO(c.getId(), c.getNome(), c.getCognome(), c.getNumero(), c.getGruppo(), c.getNascita(), c.getPreferito());
	}
	
	public static List<ContattoDTO> fromContattiToContattiDTO(List<Contatto> lc){
		return lc.stream()
			.map(c -> fromContattoToContattoDTO(c))
			.collect(Collectors.toList());
	}
	
	public static List<Contatto> fromContattiDTOToContatti(List<ContattoDTO> ldto){
		return ldto.stream()
			.map(dto -> fromContattoDTOToContatto(dto))
			.collect(Collectors.toList());
	}
	
	
	public static Rubrica fromRubricaDTOToRubrica(RubricaDTO dto) {
		Rubrica r = new Rubrica(dto.getId(), dto.getProprietario(), dto.getAnno_creazione());
		
		List<Contatto> lc = Conversion.fromContattiDTOToContatti(dto.getContatti());
		
		r.setContatti(lc);
		
		return r;
	}
	
	public static RubricaDTO fromRubricaToRubricaDTO(Rubrica r) {
		RubricaDTO dto = new RubricaDTO(r.getId(), r.getProprietario(), r.getAnno_creazione());
	
		dto.setContatti(Conversion.fromContattiToContattiDTO(r.getContatti()));
		
		return dto;
	}
	
	

}
