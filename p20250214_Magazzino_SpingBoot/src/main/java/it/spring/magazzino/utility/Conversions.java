package it.spring.magazzino.utility;


import java.util.ArrayList;
import java.util.List;

import it.spring.magazzino.dto.ProdottoDTO;
import it.spring.magazzino.dto.ProdottoNoIdDTO;
import it.spring.magazzino.entity.Prodotto;

public class Conversions {
	
	public static Prodotto fromProdottoDTOToProdotto(ProdottoNoIdDTO dto) {
		return new Prodotto(0, dto.getMarca(), dto.getModello(), 
				dto.getDescrizione(), dto.getPrezzo_consigliato(), 
				dto.getPrezzo_massimo(), dto.getN_pezzi(), dto.getCategoria());
	}
	
	public static ProdottoNoIdDTO fromProdottoToProdottoNoIdDTO(Prodotto p) {
		return new ProdottoNoIdDTO(p.getMarca(), p.getModello(), 
				p.getDescrizione(), p.getPrezzo_consigliato(), 
				p.getPrezzo_massimo(), p.getN_pezzi(), p.getCategoria());
	}
	
	public static List<ProdottoNoIdDTO> fromProdottiToProdottiNoIdDTO(List<Prodotto> lp){
		List<ProdottoNoIdDTO> ldto = new ArrayList<ProdottoNoIdDTO>();
		for(Prodotto p : lp) 
			ldto.add(fromProdottoToProdottoNoIdDTO(p));
		return ldto;
	}
	
	public static Prodotto fromProdottoDTOToProdotto(ProdottoDTO dto) {
		return new Prodotto(dto.getId(), dto.getMarca(), dto.getModello(), 
				dto.getDescrizione(), dto.getPrezzo_consigliato(), 
				dto.getPrezzo_massimo(), dto.getN_pezzi(), dto.getCategoria());
	}
	
	public static ProdottoDTO fromProdottoToProdottoDTO(Prodotto p) {
		return new ProdottoDTO(p.getId(), p.getMarca(), p.getModello(), 
				p.getDescrizione(), p.getPrezzo_consigliato(), 
				p.getPrezzo_massimo(), p.getN_pezzi(), p.getCategoria());
	}
	
	public static List<ProdottoDTO> fromProdottiToProdottiDTO(List<Prodotto> lp){
		List<ProdottoDTO> ldto = new ArrayList<ProdottoDTO>();
		for(Prodotto p : lp) 
			ldto.add(fromProdottoToProdottoDTO(p));
		return ldto;
	}

}

