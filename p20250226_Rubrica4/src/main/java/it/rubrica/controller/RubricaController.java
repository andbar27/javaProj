package it.rubrica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rubrica.dto.ContattoDTO;
import it.rubrica.dto.ElencoNomiRubricaDTO;
import it.rubrica.dto.ErroreDTO;
import it.rubrica.dto.NomeAnnoRubricaDTO;
import it.rubrica.dto.NomeCognomeDTO;
import it.rubrica.dto.NomeNumeroRubricaDTO;
import it.rubrica.dto.RubricaDTO;
import it.rubrica.service.ContattiService;
import it.rubrica.service.RubricaService;
import it.rubrica.utility.Pair;

@RestController
@RequestMapping(path="/rubriche")
public class RubricaController {
	
	@Autowired
	private RubricaService service;
	
	@Autowired
	private ContattiService cservice;
	
	// Controller per Rubriche
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void newRubrica(@RequestBody RubricaDTO dto) {
		service.newRubrica(dto);
	}
	
	@GetMapping(path="/{id}", produces = "application/json")
	public RubricaDTO selectRubrica(@PathVariable int id) {
		return service.selectRubrica(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RubricaDTO> selectAllRubrica(){
		return service.selectAllRubrica();
	}
	
	@DeleteMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean removeRubrica(@PathVariable int id) {
		return service.removeRubrica(id);
	}
	
	@GetMapping(path="/nomeAnno/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public NomeAnnoRubricaDTO selectNomeAnnoRubrica(@PathVariable int id) {
		return service.selectNomeAnnoRubrica(id);
	}
	
	@PatchMapping(path="/proprietario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RubricaDTO editProprietarioRubrica(@PathVariable int id, String proprietario) {
		return service.editProprietarioRubrica(id, proprietario);
	}
	
	@PatchMapping(path="/anno/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RubricaDTO editAnnoRubrica(@PathVariable int id, int anno) {
		return service.editAnnoRubrica(id, anno);
	}
	
	@GetMapping(path="/nomi", produces = MediaType.APPLICATION_JSON_VALUE)
	public ElencoNomiRubricaDTO viewAllNomiRubrica() {
		return service.viewAllNomiRubrica();
	}
	
	@GetMapping(path="/older", produces = MediaType.APPLICATION_JSON_VALUE)
	public NomeAnnoRubricaDTO getOlderRubrica() {
		return service.getOlderRubrica();
	}
	
	@GetMapping(path="/anni", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Integer> viewAllAnniRubrica(){
		return service.viewAllAnniRubrica();
	}
	
	@GetMapping(path="/nomeNumero/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public NomeNumeroRubricaDTO selectNomeNumeroRubrica(@PathVariable int id) {
		return service.selectNomeNumeroRubrica(id);
	}
	
	// ------------------------------------------------------
	
	// Controller per Contatti
	
	@PostMapping(path="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void newContatto(@PathVariable int id, @RequestBody ContattoDTO c) {
		cservice.newContatto(id, c);
	}
	
	@GetMapping(path="/{id}/{nome}/{cognome}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContattoDTO selectContatto(@PathVariable int id, @PathVariable String nome, @PathVariable String cognome) {
		return cservice.selectContatto(id, nome, cognome);
	}

	@PutMapping(path="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void editContatto(@PathVariable int id, @RequestBody ContattoDTO dto) {
		cservice.editContatto(id, dto);
	}
	
	@DeleteMapping(path="/{id}/{nome}/{cognome}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContattoDTO removeContatto(@PathVariable int id, @PathVariable String nome, @PathVariable String cognome) {
		return cservice.removeContatto(id, nome, cognome);
	}
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ContattoDTO> selectAllContatto(@PathVariable int id){
		return cservice.selectAllContatto(id);
	}
	
	@GetMapping(path="/{id}/size")
	public int sizeRubrica(@PathVariable int id) {
		return cservice.sizeRubrica(id);
	}
	
	@GetMapping(path="/{id}/numeri", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> numeriContatti(@PathVariable int id){
		return cservice.numeriContatti(id);
	}
	
	@GetMapping(path="/{id}/byNumero", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContattoDTO selectByNumero(@PathVariable int id, String numero) {
		return cservice.selectByNumero(id, numero);
	}
	
	@GetMapping(path="/{id}/nomeCognomeByGruppo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<NomeCognomeDTO> selectNomeCognomeByGruppo(@PathVariable int id, String gruppo){
		return cservice.selectNomeCognomeByGruppo(id, gruppo);
	}
	
	@GetMapping(path="/{id}/numeriByGruppo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> selectNumeriByGruppo(@PathVariable int id, String gruppo){
		return cservice.selectNumeriByGruppo(id, gruppo);
	}
	
	@DeleteMapping(path="/{id}/byGruppo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pair> removeByGruppo(@PathVariable int id, String gruppo){
		return cservice.removeByGruppo(id, gruppo);
	}
	
	@PatchMapping(path="/{id}/preferito/{nome}/{cognome}")
	public void setPreferitoContatto(@PathVariable int id, @PathVariable String nome, @PathVariable String cognome) {
		cservice.setPreferitoContatto(id, nome, cognome);
	}
	
	@GetMapping(path="/{id}/byPreferito", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ContattoDTO> selectByPreferito(@PathVariable int id){
		return cservice.selectByPreferito(id);
	}
	
	
	
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> handler(RuntimeException exc){
		ErroreDTO err = new ErroreDTO(exc.getMessage());
		
		ResponseEntity<ErroreDTO> resp = new ResponseEntity<ErroreDTO>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		return resp;
	}

}
