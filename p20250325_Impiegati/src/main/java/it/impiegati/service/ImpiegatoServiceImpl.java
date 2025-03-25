package it.impiegati.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.impiegati.dao.ImpiegatoDAO;
import it.impiegati.dto.ImpiegatoDTO;
import it.impiegati.dto.NomeCognomeDTO;
import it.impiegati.entity.Impiegato;
import it.impiegati.utility.Conversion;

@Service
@Transactional
public class ImpiegatoServiceImpl implements ImpiegatoService{
	
	@Autowired
	private ImpiegatoDAO dao;
	
	
	public boolean insertImpiegato(ImpiegatoDTO dto) {
		if(dao.findById(dto.getMatricola()).isPresent())
			return false;
		
		dao.save(Conversion.fromImpiegatoDTOToImpiegato(dto));
		return true;
	}
	
	public ImpiegatoDTO selectImpiegato(Integer matricola) {
		return Conversion.fromImpiegatoToImpiegatoDTO(dao.findById(matricola).get());
	}
	
	public List<ImpiegatoDTO> selectAllImpiegato(){
		return Conversion.fromImpiegatiToImpiegatiDTO(dao.findAll());
	}
	
	public ImpiegatoDTO deleteImpiegato(Integer matricola) {
		ImpiegatoDTO dto = Conversion.fromImpiegatoToImpiegatoDTO(dao.findById(matricola).get());
		dao.deleteById(matricola);
		return dto;
	}
	
	public ImpiegatoDTO updateSalarioImpiegato(Integer matricola, Double salario) {
		Impiegato i = dao.findById(matricola).get();
		if(i == null)
			return null;
		
		i.setSalario_mensile(salario);
		return Conversion.fromImpiegatoToImpiegatoDTO(i);
	}
	
	public NomeCognomeDTO deleteImpiegatoNC(Integer matricola) {
		ImpiegatoDTO dto = Conversion.fromImpiegatoToImpiegatoDTO(dao.findById(matricola).get());
		dao.deleteById(matricola);
		return new NomeCognomeDTO(dto.getNome(), dto.getCognome());
	}
	
	public List<NomeCognomeDTO> selectAllImpiegatoNC(){
		return dao.findAll().stream()
				.map(i -> new NomeCognomeDTO(i.getNome(), i.getCognome()))
				.collect(Collectors.toList());
	}
	
	public List<ImpiegatoDTO> selectWhereSalarioGT(Double salario){
		return Conversion.fromImpiegatiToImpiegatiDTO(dao.selectWhereSalarioGT(salario));
	}
	
	public List<ImpiegatoDTO> selectAllImpiegatoOrderByName(){
		List<ImpiegatoDTO> ldto = Conversion.fromImpiegatiToImpiegatiDTO(dao.findAll());
		ldto.sort((a,b) -> (a.getCognome().compareTo(b.getCognome())));
		return ldto;
	}
	
	public List<ImpiegatoDTO> selectAllImpiegatoOrderBySalary(){
		return Conversion.fromImpiegatiToImpiegatiDTO(dao.findAll()).stream()
			.sorted((a,b) -> a.getSalario_mensile().compareTo(b.getSalario_mensile()))
			.collect(Collectors.toList());
	}

}
