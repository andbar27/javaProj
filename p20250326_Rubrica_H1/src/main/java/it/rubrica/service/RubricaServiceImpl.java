package it.rubrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.rubrica.dao.RubricaDAO;
import it.rubrica.dto.ContattoDTO;
import it.rubrica.dto.RubricaDTO;
import it.rubrica.entity.Rubrica;
import it.rubrica.utility.Conversion;

@Service
@Transactional
public class RubricaServiceImpl implements RubricaService {
	
	@Autowired
	private RubricaDAO dao;

	
	
	public boolean insertRubrica(RubricaDTO dto) {
		if(dao.findById(dto.getId()).isPresent())
			return false;
		
		dao.save(Conversion.fromRubricaDTOToRubrica(dto));
		return true;
	}


	public RubricaDTO selectRubrica(Integer id) {
		return Conversion.fromRubricaToRubricaDTO(dao.findById(id).get());
	}


	public boolean insertContatto(Integer id, ContattoDTO dto) {
		Rubrica r = dao.findById(id).get();
		if(r == null)
			return false;
		
		r.aggiungiContatto(Conversion.fromContattoDTOToContatto(dto));
		return true;
	}

}
