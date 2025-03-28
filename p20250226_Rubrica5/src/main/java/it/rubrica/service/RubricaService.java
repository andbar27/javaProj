package it.rubrica.service;

import java.util.List;

import it.rubrica.dto.ElencoNomiRubricaDTO;
import it.rubrica.dto.NomeAnnoRubricaDTO;
import it.rubrica.dto.NomeNumeroRubricaDTO;
import it.rubrica.dto.RubricaDTO;

public interface RubricaService {
	
	public void newRubrica(RubricaDTO dto);
	
	public RubricaDTO selectRubrica(int id);
	
	public List<RubricaDTO> selectAllRubrica();
	
	public boolean removeRubrica(int id);
	
	public NomeAnnoRubricaDTO selectNomeAnnoRubrica(int id);
	
	public RubricaDTO editProprietarioRubrica(int id, String proprietario);
	
	public RubricaDTO editAnnoRubrica(int id, int anno);
	
	public ElencoNomiRubricaDTO viewAllNomiRubrica();
	
	public NomeAnnoRubricaDTO getOlderRubrica();
	
	public List<Integer> viewAllAnniRubrica();
	
	public NomeNumeroRubricaDTO selectNomeNumeroRubrica(int id);

}
