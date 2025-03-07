package it.rubrica.service;

import java.util.List;

import it.rubrica.dto.ContattoDTO;
import it.rubrica.dto.NomeCognomeDTO;

public interface ContattiService {
	
	public void newContatto(int id, ContattoDTO c);
	
	public ContattoDTO selectContatto(int id, String nome, String cognome);

	public void editContatto(int id, ContattoDTO dto);
	
	public ContattoDTO removeContatto(int id, String nome, String cognome);
	
	public List<ContattoDTO> selectAllContatto(int id);
	
	public int sizeRubrica(int id);
	
	public List<String> numeriContatti(int id);
	
	public ContattoDTO selectByNumero(int id, String numero);
	
	public List<NomeCognomeDTO> selectNomeCognomeByGruppo(int id, String gruppo);
	
	public List<String> selectNumeriByGruppo(int id, String gruppo);
	
	public List<String> removeByGruppo(int id, String gruppo);
	
	public void setPreferitoContatto(int id, String nome, String cognome);
	
	public List<ContattoDTO> selectByPreferito(int id);

}
