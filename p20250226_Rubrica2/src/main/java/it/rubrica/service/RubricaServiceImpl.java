package it.rubrica.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rubrica.dao.RubricaDAO;
import it.rubrica.dto.ElencoNomiRubricaDTO;
import it.rubrica.dto.NomeAnnoRubricaDTO;
import it.rubrica.dto.NomeNumeroRubricaDTO;
import it.rubrica.dto.RubricaDTO;
import it.rubrica.entity.Rubrica;
import it.rubrica.utility.Conversion;

@Service
public class RubricaServiceImpl implements RubricaService {
	
	@Autowired
	private RubricaDAO dao;
	
	public void newRubrica(RubricaDTO dto) {
		if(dao.selectById(dto.getId()) != null)
			throw new RuntimeException("id rubrica già esistente");
		dao.insert(new Rubrica(dto.getId(), dto.getProprietario(), dto.getAnno_creazione()));
	}
	
	public RubricaDTO selectRubrica(int id) {
		Rubrica entity = dao.selectById(id);
		return Conversion.fromRubricaToRubricaDTO(entity);
	}
	
	public List<RubricaDTO> selectAllRubrica(){
		return Conversion.fromRubricheToRubricheDTO(dao.selectAll());
	}
	
	public boolean removeRubrica(int id) {
		return dao.delete(id);
	}
	
	public NomeAnnoRubricaDTO selectNomeAnnoRubrica(int id) {
		Rubrica r = dao.selectById(id);
		return new NomeAnnoRubricaDTO(r.getProprietario(), r.getAnno_creazione());
	}
	
	public RubricaDTO editProprietarioRubrica(int id, String proprietario) {
		Rubrica r = dao.selectById(id);
		r.setProprietario(proprietario);
		return Conversion.fromRubricaToRubricaDTO(r);
	}
	
	public RubricaDTO editAnnoRubrica(int id, int anno) {
		Rubrica r = dao.selectById(id);
		r.setAnno_creazione(anno);
		return Conversion.fromRubricaToRubricaDTO(r);
	}
	
	public ElencoNomiRubricaDTO viewAllNomiRubrica() {
		ElencoNomiRubricaDTO dto = new ElencoNomiRubricaDTO();
		
		for(Rubrica r : dao.selectAll()) 
			dto.addNome(r.getProprietario());
		
		return dto;
	}
	
	public NomeAnnoRubricaDTO getOlderRubrica() {
		NomeAnnoRubricaDTO dto = new NomeAnnoRubricaDTO();
		List<Rubrica> lr = dao.selectAll();
		int old = lr.get(0).getAnno_creazione();
		String nome = lr.get(0).getProprietario();
		
		for(Rubrica r : lr) {
			int anno = r.getAnno_creazione();
			if(anno < old) {
				old = anno;
				nome = r.getProprietario();
			}
		}
		
		dto.setData_creazione(old);
		dto.setNome_proprietario(nome);
		return dto;
	}
	
	public List<Integer> viewAllAnniRubrica(){
		List<Integer> anni = new ArrayList<Integer>();
		
		for(Rubrica r : dao.selectAll()) 
			anni.add(r.getAnno_creazione());
		
		Collections.sort(anni);
		return anni;
	}
	
	public NomeNumeroRubricaDTO selectNomeNumeroRubrica(int id) {
		Rubrica r = dao.selectById(id);
		return new NomeNumeroRubricaDTO(r.getProprietario(), r.getContatti().size());
	}

}
