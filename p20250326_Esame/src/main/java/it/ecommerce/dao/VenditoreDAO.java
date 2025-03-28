package it.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.ecommerce.dto.ProfiloVenditoreDTO;
import it.ecommerce.entity.Venditore;

public interface VenditoreDAO extends JpaRepository<Venditore, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM Venditore WHERE id = :id")
	ProfiloVenditoreDTO selectProfiloVenditore(Integer id);

}
