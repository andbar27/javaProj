package it.rubrica.service;

import it.rubrica.dto.ContattoDTO;
import it.rubrica.dto.RubricaDTO;

public interface RubricaService {
	
	public boolean insertRubrica(RubricaDTO dto);
	public RubricaDTO selectRubrica(Integer id);
	public boolean insertContatto(Integer id, ContattoDTO dto);

}
