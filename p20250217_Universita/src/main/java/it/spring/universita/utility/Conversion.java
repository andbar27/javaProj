package it.spring.universita.utility;

import java.util.ArrayList;
import java.util.List;

import it.spring.universita.dto.NomeStudenteDTO;
import it.spring.universita.dto.ProfessoreDTO;
import it.spring.universita.dto.StudenteDTO;
import it.spring.universita.entity.Professore;
import it.spring.universita.entity.Studente;

public class Conversion {
	
	// Studente
	
	public static Studente fromStudenteDTOToStudente(StudenteDTO dto) {
		return new Studente(dto.getMatricola(), dto.getNome(), dto.getCognome(), 
				dto.getIndirizzo(), dto.getAnno_nascita(), dto.getAnno_immatricolazione());
	}
	
	public static StudenteDTO fromStudenteToStudenteDTO(Studente dto) {
		return new StudenteDTO(dto.getMatricola(), dto.getNome(), dto.getCognome(), 
				dto.getIndirizzo(), dto.getAnno_nascita(), dto.getAnno_immatricolazione());
	}
	
	public static List<StudenteDTO> fromStudentiToStudentiDTO(List<Studente> ls){
		List<StudenteDTO> ldto = new ArrayList<StudenteDTO>();
		for(Studente s : ls)
			ldto.add(fromStudenteToStudenteDTO(s));
		
		return ldto;
	}
	
	public static NomeStudenteDTO fromStudenteToNomeStudenteDTO(Studente s) {
		return new NomeStudenteDTO(s.getNome());
	}
	
	public static List<NomeStudenteDTO> fromStudentiToNomiStudentiDTO(List<Studente> ls){
		List<NomeStudenteDTO> ldto = new ArrayList<NomeStudenteDTO>();
		for(Studente s : ls)
			ldto.add(fromStudenteToNomeStudenteDTO(s));
		
		return ldto;
	}
	
	public static List<String> getNomiStudenti(List<Studente> ls){
		List<String> nomi = new ArrayList<String>();
		for(Studente s : ls) 
			nomi.add(s.getNome());
		
		return nomi;
	}
	
	
	// Professore
	
	public static Professore fromProfessoreDTOToProfessore(ProfessoreDTO dto) {
		return new Professore(dto.getId(), dto.getNome(), dto.getCognome(), dto.getMateria());
	}
	
	public static ProfessoreDTO fromProfessoreToProfessoreDTO(Professore p) {
		return new ProfessoreDTO(p.getId(), p.getNome(), p.getCognome(), p.getMateria());
	}
	
	public static List<ProfessoreDTO> fromProfessoriToProfessoriDTO(List<Professore> lp){
		List<ProfessoreDTO> ldto = new ArrayList<ProfessoreDTO>();
		for(Professore p : lp) 
			ldto.add(fromProfessoreToProfessoreDTO(p));
		
		return ldto;
		
	}
	

}
