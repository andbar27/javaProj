package it.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.ecommerce.dao.VenditoreDAO;
import it.ecommerce.dto.ProdottoDTO;
import it.ecommerce.dto.ProfiloVenditoreDTO;
import it.ecommerce.dto.VenditoreDTO;
import it.ecommerce.entity.Prodotto;
import it.ecommerce.entity.Venditore;
import it.ecommerce.utility.Conversion;

@Service
@Transactional
public class VenditoreServiceImpl implements VenditoreService {
	
	@Autowired
	private VenditoreDAO dao;
	
	
	public boolean insertVenditore(VenditoreDTO dto) {
		if(dao.findById(dto.getId()).isPresent())
			return false;
		
		return dao.save(Conversion.fromVenditoreDTOToVenditore(dto)) != null;	
	}
	
	
	public VenditoreDTO selectVenditore(Integer id) {
		return Conversion.fromVenditoreToVenditoreDTO(dao.findById(id).get());
	}
	
	
	public ProfiloVenditoreDTO selectProfiloVenditore(Integer id) {
		// Query personalizzata nel dao
		ProfiloVenditoreDTO dto = dao.selectProfiloVenditore(id);
		if(dto == null)
			throw new RuntimeException("No value present");
		
		return dto;
		
		// Venditore v = dao.findById(id).get();
		
		/* if(v == null)
			throw new RuntimeException("Venditore non presente");
		
			NON SERVE GIÀ .get() lancia un'eccezione se non c'è il valore.
		*/
		
		// return new ProfiloVenditoreDTO(v.getId(), v.getNome(), v.getCognome(), v.getUsername(), v.getPassword(), v.getVia(), v.getCitta());
	}
	
	
	public VenditoreDTO patchPasswordVenditore(Integer id, String pw) {
		Venditore v = dao.findById(id).get(); 	// Managed
		
		v.setPassword(pw); 						//
		return Conversion.fromVenditoreToVenditoreDTO(v);
	}
	
	
	public boolean insertProdotto(Integer idV, ProdottoDTO dtoP) {
		Venditore v = dao.findById(idV).get();
		
		Prodotto p = Conversion.fromProdottoDTOToProdotto(dtoP);
		v.addProdotto(p);
		
		return v.getProdotti().contains(p);
	}
	
	
	public ProdottoDTO patchQuantitaProdotto(Integer idV, Integer idP, Integer quantita) {
		Venditore v = dao.findById(idV).get();
		
		Prodotto p = v.getProdotto(idP);
		if(p == null)
			throw new RuntimeException("No prodotto present");
		
		p.setQuantita(quantita);
		
		return Conversion.fromProdottoToProdottoDTO(p);
	}
	
	
}
