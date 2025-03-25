package it.impiegati.service;

import java.util.List;

import it.impiegati.dto.ImpiegatoDTO;
import it.impiegati.dto.NomeCognomeDTO;

public interface ImpiegatoService {
	
	public boolean insertImpiegato(ImpiegatoDTO dto);
	
	public ImpiegatoDTO selectImpiegato(Integer matricola);
	
	public List<ImpiegatoDTO> selectAllImpiegato();
	
	public ImpiegatoDTO deleteImpiegato(Integer matricola);
	
	public ImpiegatoDTO updateSalarioImpiegato(Integer matricola, Double salario);

	
	public NomeCognomeDTO deleteImpiegatoNC(Integer matricola);
	
	public List<NomeCognomeDTO> selectAllImpiegatoNC();
	
	public List<ImpiegatoDTO> selectWhereSalarioGT(Double salario);
	
	public List<ImpiegatoDTO> selectAllImpiegatoOrderByName();
	
	public List<ImpiegatoDTO> selectAllImpiegatoOrderBySalary();
}
