package it.impiegati.utility;

import java.util.List;
import java.util.stream.Collectors;

import it.impiegati.dto.ImpiegatoDTO;
import it.impiegati.entity.Impiegato;

public class Conversion {
	
	public static Impiegato fromImpiegatoDTOToImpiegato(ImpiegatoDTO dto){
		return new Impiegato(dto.getMatricola(), dto.getNome(), dto.getCognome(), dto.getSalario_mensile());
	}
	
	public static ImpiegatoDTO fromImpiegatoToImpiegatoDTO(Impiegato i){
		return new ImpiegatoDTO(i.getMatricola(), i.getNome(), i.getCognome(), i.getSalario_mensile());
	}
	
	public static List<Impiegato> fromImpiegatiDTOToImpiegati(List<ImpiegatoDTO> ldto){
		return ldto.stream()
				.map(dto -> fromImpiegatoDTOToImpiegato(dto))
				.collect(Collectors.toList());
	}
	
	public static List<ImpiegatoDTO> fromImpiegatiToImpiegatiDTO(List<Impiegato> li){
		return li.stream()
				.map(i -> fromImpiegatoToImpiegatoDTO(i))
				.collect(Collectors.toList());
	}

}
