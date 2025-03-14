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
import java.sql.Date;

import org.springframework.stereotype.Repository;

import it.rubrica.entity.Contatto;
import it.rubrica.entity.Rubrica;

@Repository
public class RubricaDAOImpl implements RubricaDAO{
	
	// carico i driver in memoria
	String driver = "org.postgresql.Driver";
	
	
	// url di connessione
	String url = "jdbc:postgresql://localhost:5432/Rubrica?user=postgres&password=postgres&ssl=false";

	
	// Costruttore
	public RubricaDAOImpl() {
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("connessione fallita: " + e.getMessage());
		}
		int a = 10;
		int b = 10;
		System.out.println((b++ == a) + " b: " + (a == b));
		System.out.println(a+=1);
		System.out.println(a);
	}
	
	
	public Connection connect() {
		try {
			return DriverManager.getConnection(this.url);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("connessione fallita: " + e.getMessage());
		}
	}
	
	
	// --------------------------------------------------------------
	
	
	
	// DAO funzioni per conversione ResultSet to Entity
	
	
	public static Map<String, Contatto> fromResultSetToContatti(ResultSet res) throws SQLException{
		Map<String, Contatto> contatti = new HashMap<String, Contatto>();
		
		while(res.next()) {
			Contatto c = new Contatto();
			c.setNome(res.getString("nome"));
			c.setCognome(res.getString("cognome"));
			c.setNumero(res.getString("numero"));
			c.setGruppo(res.getString("gruppo"));
			c.setData_nascita(res.getDate("data_nascita"));
			c.setPreferito(res.getBoolean("preferito"));
			
			contatti.put(c.getNome()+c.getCognome(), c);
		}

		return contatti;
	}
	
	
	public Map<String, Contatto> getContattiRubrica(Integer idRubrica){
		String query = "select c.* from Contatto c, Rubrica r where c.rubrica = r.id and r.id = " + idRubrica;
		
		Connection conn = this.connect();
		
		Map<String, Contatto> contatti = null;
		
		Statement stm;
		
		try {
			stm = conn.createStatement();
			ResultSet res = stm.executeQuery(query);
			contatti = fromResultSetToContatti(res);
			
			res.close();
			stm.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("problemi esecuzione query: " + e.getMessage());
		}
		
		return contatti;
	}
	
	
	public List<Rubrica> fromResultSetToRubriche(ResultSet res) throws SQLException{
		List<Rubrica> lr = new ArrayList<Rubrica>();
		
		while(res.next()) {
			Rubrica r = new Rubrica();
			r.setId(res.getInt("id"));
			r.setProprietario(res.getString("proprietario"));
			r.setAnno_creazione(res.getInt("anno_creazione"));
			r.setContatti(this.getContattiRubrica(r.getId()));
			lr.add(r);
		}

		return lr;
	}
	
	public Rubrica fromResultSetToRubrica(ResultSet res) throws SQLException {
		List<Rubrica> lr = fromResultSetToRubriche(res);
		if(lr.size() == 0)
			return null;
		return lr.get(0);
	}
	
	// --------------------------------------------------------------
	
	
	
	// DAO funzioni per tabella Rubrica
	
	
	public List<Rubrica> selectAll(){
		Connection conn = this.connect();

		String queryR = "Select * from Rubrica";
		
		List<Rubrica> lr = null;
		
		Statement stm;
		
		try {
			stm = conn.createStatement();
			ResultSet resR = stm.executeQuery(queryR);
			lr = this.fromResultSetToRubriche(resR);
			
			resR.close();
			stm.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("problemi esecuzione query: " + e.getMessage());
		}
		
		return lr;
	}
	

	public Rubrica selectById(Integer idRubrica) {
		Connection conn = this.connect();

		String query = "Select * from Rubrica where id = " + idRubrica;
		
		Statement stm;
		
		try {
			stm = conn.createStatement();
			ResultSet res = stm.executeQuery(query);
			Rubrica r = this.fromResultSetToRubrica(res);
			if(r == null)
				throw new RuntimeException("id rubrica non presente");
			
			res.close();
			stm.close();
			conn.close();
			
			return r;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("problemi esecuzione query: " + e.getMessage());
		}
	}
	
	public Rubrica selectByIdSafe(Integer idRubrica) {
		Connection conn = this.connect();

		String query = "Select * from Rubrica where id = " + idRubrica;
		
		Statement stm;
		
		try {
			stm = conn.createStatement();
			ResultSet res = stm.executeQuery(query);
			Rubrica r = this.fromResultSetToRubrica(res);
			
			res.close();
			stm.close();
			conn.close();
			
			return r;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("problemi esecuzione query: " + e.getMessage());
		}
	}
	

	
	public boolean insert(Rubrica rubrica) {
		if(selectByIdSafe(rubrica.getId()) != null)
			throw new RuntimeException("id rubrica già presente");
		
		Connection conn = this.connect();
		
		String query = "INSERT INTO Rubrica (proprietario, anno_creazione) VALUES (?, ?);";
		
		try {
			PreparedStatement prep = conn.prepareStatement(query);
			prep.setString(1, rubrica.getProprietario());
			prep.setInt(2, rubrica.getAnno_creazione());
			
			prep.execute();
			
			prep.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("problemi esecuzione query: " + e.getMessage());
		}

		return true;
	}
	
	
	public boolean delete(Integer idRubrica) {
		selectById(idRubrica);
		
		Connection conn = this.connect();
		String query = "DELETE FROM Rubrica WHERE id = " + idRubrica;
		Statement stm;
		
		try {
			stm = conn.createStatement();
			stm.execute(query);
			
			stm.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("problemi esecuzione query: " + e.getMessage());
		}
		
		return true;
	}
	
	
	public Rubrica edit(Rubrica rubrica) {
		
		Connection conn = this.connect();
		
		String proprietario = rubrica.getProprietario();
		Integer anno_creazione = rubrica.getAnno_creazione();
		
		
		String query = "UPDATE Rubrica SET proprietario = ?, anno_creazione = ? WHERE id = ?;";
		
		try {
			PreparedStatement prep = conn.prepareStatement(query);
			prep.setString(1, proprietario);
			prep.setInt(2, anno_creazione);
			prep.setInt(3, rubrica.getId());
			
			prep.execute();
			
			prep.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("problemi esecuzione query: " + e.getMessage());
		}

		return selectByIdSafe(rubrica.getId());
	}
	
	// --------------------------------------------------------------
	
	
	
	// DAO funzioni per tabella Contatto
	
	
	public List<Contatto> selectAllContatti(){
		String query = "select * from Contatti";
		
		Connection conn = this.connect();
		
		Map<String, Contatto> contatti = null;
		
		Statement stm;
		
		try {
			stm = conn.createStatement();
			ResultSet res = stm.executeQuery(query);
			contatti = fromResultSetToContatti(res);
			
			res.close();
			stm.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("problemi esecuzione query: " + e.getMessage());
		}
		
		return (List<Contatto>) contatti.values();
	}
	
	
	public Contatto selectContattoById(String nome, String cognome, int idRubrica) {
		Connection conn = this.connect();

		String query = "Select * from Contatto where nome = ? and cognome = ? and rubrica = ?";
		
		Map<String, Contatto> contatti = null;

		
		try {
			PreparedStatement prep = conn.prepareStatement(query);
			
			prep.setString(1, nome);
			prep.setString(2, cognome);
			prep.setInt(3, idRubrica);
			
			ResultSet res = prep.executeQuery();
			contatti = fromResultSetToContatti(res);
			
			prep.close();
			res.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("problemi esecuzione query: " + e.getMessage());
		}
		
		return contatti.get(nome + cognome);
	}
	
	
	
	public boolean insertContatto(Contatto contatto, Integer idRubrica) {
		if(selectContattoById(contatto.getNome(), contatto.getCognome(), idRubrica) != null)
			throw new RuntimeException("id contatto già presente");
		
		Connection conn = this.connect();
		
		String query = "INSERT INTO Contatto (nome, cognome, numero, gruppo, data_nascita, preferito, rubrica) VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement prep = conn.prepareStatement(query);
			
			prep.setString(1, contatto.getNome());
			prep.setString(2, contatto.getCognome());
			prep.setString(3, contatto.getNumero());
			prep.setString(4, contatto.getGruppo());
			prep.setDate(5, contatto.getData_nascita());
			prep.setBoolean(6, contatto.isPreferito());
			prep.setInt(7, idRubrica);
			
			prep.execute();
			
			prep.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("problemi esecuzione query: " + e.getMessage());
		}

		return true;
	}
	
	
	public boolean deleteContatto(String nome, String cognome, int idRubrica) {
		if(selectContattoById(nome, cognome, idRubrica) == null)
			throw new RuntimeException("id contatto non presente");
		
		Connection conn = this.connect();
		String query = "DELETE FROM Contatto WHERE nome = ? and cognome = ? and rubrica = ?";
		
		try {
			PreparedStatement prep = conn.prepareStatement(query);
			
			prep.setString(1, nome);
			prep.setString(2, cognome);
			prep.setInt(3, idRubrica);
			
			prep.execute();
			
			prep.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("problemi esecuzione query: " + e.getMessage());
		}
		
		return true;
	}
	
	
	public Contatto editContatto(Contatto contatto, int idRubrica) {
		
		Connection conn = this.connect();
		
		String query = "UPDATE Contatto SET numero = ?, gruppo = ?, data_nascita = ?, preferito = ? WHERE rubrica = ? AND nome = ? AND cognome = ?;";
		
		String numero = contatto.getNumero();
		String gruppo = contatto.getGruppo();
		Date data_nascita = contatto.getData_nascita();
		Boolean preferito = contatto.isPreferito();
		
		try {
			PreparedStatement prep = conn.prepareStatement(query);
			
			prep.setString(1, numero);
			prep.setString(2, gruppo);
			prep.setDate(3, data_nascita);
			prep.setBoolean(4, preferito);
			prep.setInt(5, idRubrica);
			prep.setString(6, contatto.getNome());
			prep.setString(7, contatto.getCognome());
			
			prep.execute();
			
			prep.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("problemi esecuzione query: " + e.getMessage());
		}

		return contatto;
	}

	// --------------------------------------------------------------
}
