package it.impiegati.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.impiegati.entity.Impiegato;


public interface ImpiegatoDAO extends JpaRepository<Impiegato, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM Impiegato WHERE salario_mensile > :salario")
	List<Impiegato> selectWhereSalarioGT(Double salario);

}
