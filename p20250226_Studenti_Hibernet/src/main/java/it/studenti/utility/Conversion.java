package it.studenti.utility;

import java.util.ArrayList;
import java.util.List;

import it.studenti.dto.StudenteDTO;
import it.studenti.entity.Studente;

public class Conversion {
	
	public static Studente fromStudenteDTOToStudente(StudenteDTO dto) {
		return new Studente(dto.getMatricola(), dto.getNome(), dto.getCognome(), 
				dto.getAnnoImmatricolazione());
	}
	
	public static StudenteDTO fromStudenteToStudenteDTO(Studente s) {
		return new StudenteDTO(s.getMatricola(), s.getNome(), s.getCognome(), 
				s.getAnnoImmatricolazione());
	}
	
	public static List<StudenteDTO> fromStudentiToStudentiDTO(List<Studente> ls){
		List<StudenteDTO> ldto = new ArrayList<StudenteDTO>();
		
		for(Studente s : ls)
			ldto.add(fromStudenteToStudenteDTO(s));
		
		return ldto;
	}

}
