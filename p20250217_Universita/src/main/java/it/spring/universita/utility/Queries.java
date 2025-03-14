package it.spring.universita.utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.spring.universita.dto.CognomeImmatricolazioneDTO;
import it.spring.universita.dto.CognomeNascitaDTO;
import it.spring.universita.dto.MaterieDTO;
import it.spring.universita.dto.ProfessoreDTO;
import it.spring.universita.entity.Professore;
import it.spring.universita.entity.Studente;

public class Queries {
	
	public static CognomeNascitaDTO getYoungerStudente(List<Studente> ls) {
		Studente younger = null;
		int max = 0;
		if(ls.size() > 0) {
			younger = ls.get(0);
			max = younger.getAnno_nascita();
		}
		
		for(Studente s : ls) {
			int nascita = s.getAnno_nascita();
			if(nascita > max) {
				max = nascita;
				younger = s;
			}
		}
		
		if(younger == null)
			return null;
		
		CognomeNascitaDTO dto = new CognomeNascitaDTO();
		dto.setCognome(younger.getCognome());
		dto.setAnno_nascita(younger.getAnno_nascita());
		return dto;
	}
	
	public static CognomeImmatricolazioneDTO getOlderFreqStudente(List<Studente> ls) {
		Studente older = null;
		int min = 0;
		if(ls.size() > 0) {
			older = ls.get(0);
			min = older.getAnno_nascita();
		}
		
		for(Studente s : ls) {
			int iscrizione = s.getAnno_immatricolazione();
			if(iscrizione < min) {
				min = iscrizione;
				older = s;
			}
		}
		
		if(older == null)
			return null;
		
		CognomeImmatricolazioneDTO dto = new CognomeImmatricolazioneDTO();
		dto.setCognome(older.getCognome());
		dto.setAnno_immatricolazione(older.getAnno_nascita());
		return dto;
	}
	
	public static List<ProfessoreDTO> viewAllProfessoreMateria(List<Professore> lp, String materia){
		List<ProfessoreDTO> ldto = new ArrayList<ProfessoreDTO>();
		for(Professore p : lp) {
			if(p.getMateria() == materia)
				ldto.add(Conversion.fromProfessoreToProfessoreDTO(p));
		}
		return ldto;
	}
	
	public static MaterieDTO viewAllMateria(List<Professore> lp) {
		Set<String> materie = new HashSet<String>();
		for(Professore p : lp) 
			materie.add(p.getMateria());
		
		MaterieDTO dto = new MaterieDTO();
		dto.setMaterie(new ArrayList<String>(materie));
		return dto;
	}

}
