package it.rubrica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import it.rubrica.entity.Rubrica;

@Repository
public class RubricaDAOImpl implements RubricaDAO{
	private Map<Integer, Rubrica> mappa = new HashMap<>();
	
	// 1) Carico i driver in memoria
	String driver = "org.postgresql.Driver";
	
	
	// 2) Creo url di connessione
	String url = "jdbc:postgresql://localhost:5432/rubrica?user=postgres&password=postgres&ssl=false";

	public RubricaDAOImpl() {
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("connessione fallita");
		}
	}
	
	public Connection connect() {
		try {
			Connection conn = DriverManager.getConnection(this.url);
			return conn;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("connessione fallita");
		}
	}
	

	
	public boolean insert(Rubrica rubrica) {
		if(mappa.containsKey(rubrica.getId()))
			throw new RuntimeException("id rubrica già presente");
		
		mappa.put(rubrica.getId(), rubrica);
		return true;
	}
	
	public List<Rubrica> selectAll(){
		return new ArrayList<Rubrica>(mappa.values());
	}

	public Rubrica selectById(Integer idRubrica) {
		if(!mappa.containsKey(idRubrica))
			throw new RuntimeException("id rubrica non presente");
		return mappa.get(idRubrica);
	}
	
	public boolean delete(Integer idRubrica) {
		if(!mappa.containsKey(idRubrica))
			throw new RuntimeException("id rubrica non presente");
		Rubrica rubrica = mappa.remove(idRubrica);
		return rubrica != null;
	}

}
