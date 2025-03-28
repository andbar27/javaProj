package it.ecommerce.service;

import it.ecommerce.dto.ProdottoDTO;
import it.ecommerce.dto.ProfiloVenditoreDTO;
import it.ecommerce.dto.VenditoreDTO;


public interface VenditoreService {
	
	public boolean insertVenditore(VenditoreDTO dto);
	
	
	public VenditoreDTO selectVenditore(Integer id);
	
	
	public ProfiloVenditoreDTO selectProfiloVenditore(Integer id);
	
	
	public VenditoreDTO patchPasswordVenditore(Integer id, String pw);
	
	
	public boolean insertProdotto(Integer idV, ProdottoDTO dtoP);
	
	
	public ProdottoDTO patchQuantitaProdotto(Integer idV, Integer idP, Integer quantita);

}
