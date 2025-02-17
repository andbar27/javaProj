package it.spring.magazzino.service;

import java.util.List;

import it.spring.magazzino.dao.DAOmappaProdotti;
import it.spring.magazzino.dto.ProdottoDTO;
import it.spring.magazzino.dto.ProdottoNoIdDTO;
import it.spring.magazzino.dto.ReportDTO;
import it.spring.magazzino.entity.Prodotto;
import it.spring.magazzino.utility.Report;
import it.spring.magazzino.utility.Conversions;

public class ProdottoService {
	private DAOmappaProdotti dao = new DAOmappaProdotti();
	
	public boolean caricaProdotto(ProdottoDTO dto) {
		return dao.insert(Conversions.fromProdottoDTOToProdotto(dto));
	}
	
	
	public ProdottoDTO getById(int id) {
		Prodotto p = dao.selectById(id);
		if(p == null)
			return null;
		return Conversions.fromProdottoToProdottoDTO(dao.selectById(id));
	}
	
	public List<ProdottoDTO> getAll(){
		return Conversions.fromProdottiToProdottiDTO(dao.selectAll());
	}
	
	public List<ProdottoNoIdDTO> getAllNoId(){
		return Conversions.fromProdottiToProdottiNoIdDTO(dao.selectAll());
	}
	
	public ReportDTO getReport() {
		List<Prodotto> lp = dao.selectAll();
		ReportDTO reportDTO = new ReportDTO();
		
		// inserisco descrizioni
		reportDTO.setDescrizioni(Report.getDescrizioni(lp));
		
		// inserisco somma pezzi prodotti
		reportDTO.setN_pezzi(Report.sumQuantita(lp));
		
		// prodotti non disponibili
		List<String> indisponibili = Report.prodIndisponibili(lp);
		reportDTO.setN_notDisponibili(indisponibili.size());
		reportDTO.setProdotti_notDisponibili(indisponibili);
		
		// media prezzi
		reportDTO.setMedia_prezzi(Report.mediaPrezzi(lp));
		
		// mappa prodotti categoria
		reportDTO.setId_per_categoria(Report.mappaCategoriaId(lp));
		
		return reportDTO;
	}

}
