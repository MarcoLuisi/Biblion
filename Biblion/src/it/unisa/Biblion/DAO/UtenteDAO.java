package it.unisa.Biblion.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import it.unisa.Biblion.Model.*;





public class UtenteDAO {
	
	/** La query per l'inserimento di un nuovo cliente */
    private static final String CREATE_QUERY = "INSERT INTO utente (cf, nome, cognome, passwordUtente, email, nomeUtente, indirizzo, amministratore) VALUES (?,?,?,?,?,?,?,?)";
    
    /** La query per la lettura di un singolo cliente. */
    private static final String READ_QUERY = "SELECT * FROM utente WHERE cf = ?";
    
    /** La query per la lettura di tutti i clienti. */
    private static final String READ_ALL_QUERY = "SELECT * FROM utente";
    
    /** La query per l'aggiornamento di un singolo cliente. */
    private static final String UPDATE_QUERY = "UPDATE utente SET nome=?, cognome=?, passwordUtente?, email=?, nomeUtente=?, indirizzo=?, amministratore=? WHERE cf = ?";
    
    /** La query per la cancellazione di un singolo cliente. */
    private static final String DELETE_QUERY = "DELETE FROM utente WHERE cf = ?";
    
    private static final String CHECK = "Select cf from utente where cf = ?";
    
    public List<Utente> getAllUtenti() {
		List<Utente> utenti = new ArrayList<Utente>();
		Utente utente = null;
		Connection con = null;
		PreparedStatement statement = null;
        ResultSet result = null;
        
        try {
        	con = MySQLDAO.createConnection();
        	statement = con.prepareStatement(READ_ALL_QUERY);
        	statement.execute();
        	result = statement.getResultSet();
        	
        	while(result.next()) {
        		utente = new Utente(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), 
        				result.getString(6), result.getString(7), result.getBoolean(8));
        		utenti.add(utente);
        	}
        	
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
		
		return utenti;
	}
    
    public Utente getUtente(String cf) {
		Utente utente = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		 try {
	            con = MySQLDAO.createConnection();
	            statement = con.prepareStatement(READ_QUERY);
	            statement.setString(1, cf);
	            statement.execute();
	            result = statement.getResultSet();
	 
	            if (result.next() && result != null) {
	        		utente = new Utente(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), 
	        				result.getString(6), result.getString(7), result.getBoolean(8));
	            } 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                result.close();
	            } catch (Exception rse) {
	                rse.printStackTrace();
	            }
	            try {
	                statement.close();
	            } catch (Exception sse) {
	                sse.printStackTrace();
	            }
	            try {
	                con.close();
	            } catch (Exception cse) {
	                cse.printStackTrace();
	            }
	        }
	 
		
		return utente;
	}
    
    public boolean createUtente(Utente utente) {
		Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(CREATE_QUERY);
          
            statement.setString(1, utente.getCf());
            statement.setString(2, utente.getNome());
            statement.setString(3, utente.getCognome());
            statement.setString(4, utente.getPassword());
            statement.setString(5, utente.getEmail());
            statement.setString(6, utente.getNomeutente());
            statement.setString(7, utente.getIndirizzo());
            statement.setBoolean(8, utente.isAdmin());
            int check= statement.executeUpdate();
            
            if (check>1) {
                return true; //successo
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        
            try {
            	statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
 
        return false;

	}
    
    public boolean deleteUtente(Utente utente) {
		Connection con = null;
        PreparedStatement statement = null;
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(DELETE_QUERY);
            statement.setString(1, utente.getCf());
            int check = statement.executeUpdate();
            
            if (check > 0) {
            	return true;
            }
            
            else return false;

            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
            	statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
            	con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return false;
	}
    
    public boolean checkCF (String cf) {
    	
		Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(CHECK);
            statement.setString(1, cf);
            statement.execute();
            result = statement.getResultSet();
            
            if (!result.isBeforeFirst() ) { 
            	
                return false;
                
            } 
            
            else {
            	return true;
            }

            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
            	statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
            	con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return false;
    	
    	
    }
    
   
}
