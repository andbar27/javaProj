package p20241206_Aerei;

import java.util.LinkedList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Agenzia {
	public LinkedList<Compagnia> lista_compagnie;

	public Agenzia() {
		super();
		this.lista_compagnie = new LinkedList<Compagnia>();
	}
	
	
	public void addCompagnia(Compagnia c) {
		this.lista_compagnie.add(c);
	}
	
	
	public String generateJSON() throws JsonProcessingException {
		ObjectMapper objMapper = new ObjectMapper();
		// Converto da Oggetto a JSON
		String jsonString = objMapper.writeValueAsString(this);
		
		System.out.println(jsonString);
		
		return jsonString;
	}
	
	public static Agenzia generateByJSON(String jsonString) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.readValue(jsonString, Agenzia.class);
		
	}
		
	

}
