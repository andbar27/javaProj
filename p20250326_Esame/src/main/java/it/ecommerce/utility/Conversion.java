package it.ecommerce.utility;

import java.util.List;
import java.util.stream.Collectors;

import it.ecommerce.dto.ProdottoDTO;
import it.ecommerce.dto.VenditoreDTO;
import it.ecommerce.entity.Prodotto;
import it.ecommerce.entity.Venditore;

public class Conversion {
	
	public static Prodotto fromProdottoDTOToProdotto(ProdottoDTO dto) {
		return new Prodotto(dto.getId(), dto.getDescrizione(), dto.getQuantita(), dto.getPrezzo(), dto.getSconto(), dto.getCategoria());
	}
	
	public static ProdottoDTO fromProdottoToProdottoDTO(Prodotto p) {
		return new ProdottoDTO(p.getId(), p.getDescrizione(), p.getQuantita(), p.getPrezzo(), p.getSconto(), p.getCategoria());
	}
	
	public static List<Prodotto> fromProdottiDTOToProdotti(List<ProdottoDTO> ldto){
		return ldto.stream()
				.map(dto -> fromProdottoDTOToProdotto(dto))
				.collect(Collectors.toList());
	}
	
	public static List<ProdottoDTO> fromProdottiToProdottiDTO(List<Prodotto> lp){
		return lp.stream()
				.map(p -> fromProdottoToProdottoDTO(p))
				.collect(Collectors.toList());
	}
	
	
	public static Venditore fromVenditoreDTOToVenditore(VenditoreDTO dto) {
		Venditore v = new Venditore(dto.getId(), dto.getNome(), dto.getCognome(), dto.getUsername(), dto.getPassword(), dto.getVia(), dto.getCitta());
		
		v.setProdotti(fromProdottiDTOToProdotti(dto.getProdotti()));
		
		return v;
	}
	
	public static VenditoreDTO fromVenditoreToVenditoreDTO(Venditore v) {
		VenditoreDTO dto = new VenditoreDTO(v.getId(), v.getNome(), v.getCognome(), v.getUsername(), v.getPassword(), v.getVia(), v.getCitta());
		
		dto.setProdotti(fromProdottiToProdottiDTO(v.getProdotti()));
		
		return dto;
	}
	
	public static List<Venditore> fromVenditoriDTOToVenditori(List<VenditoreDTO> ldto){
		return ldto.stream()
				.map(dto -> fromVenditoreDTOToVenditore(dto))
				.collect(Collectors.toList());
	}
	
	public static List<VenditoreDTO> fromVenditoriToVenditoriDTO(List<Venditore> lv){
		return lv.stream()
				.map(v -> fromVenditoreToVenditoreDTO(v))
				.collect(Collectors.toList());
	}
	
}
