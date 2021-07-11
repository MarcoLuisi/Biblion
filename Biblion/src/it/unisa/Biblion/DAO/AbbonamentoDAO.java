package it.unisa.Biblion.DAO;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import it.unisa.Biblion.Model.*;

public class AbbonamentoDAO {
	
	private static final String READ_ALL_QUERY = "select * from abbonamento a  where a.id_servizio = 1";
	private static final String READ_ALL_QUERY1 = "select * from abbonamento a  where a.id_servizio = 2";
	
	private static final String CREATE_QUERY = "INSERT INTO abbonamento (cf_utente, username, passAbb, id_servizio, durata, costo) "
			+ "VALUES (?,?,?,?,?,?)";
	
	private static final String READ_LIBRI_ABBONAMENTO="select l.isbn, l.quantita, l.titolo, l.editore, l.tipo, l.annoEdizione, l.genere, l.prezzo, l.pagine, l.ebook, l.audiolibro, l.autore from libro l, offerta_abbonamento a where l.isbn = a.isbn and a.id_servizio=1";
	private static final String READ_LIBRI_ABBONAMENTO1="select l.isbn, l.quantita, l.titolo, l.editore, l.tipo, l.annoEdizione, l.genere, l.prezzo, l.pagine, l.ebook, l.audiolibro, l.autore from libro l, offerta_abbonamento a where l.isbn = a.isbn and a.id_servizio=2";
	
	public boolean createAbbonamento(Abbonamento a) {
		Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(CREATE_QUERY);
          
            statement.setString(1, a.getCf_utente());
            statement.setString(2, a.getUsername());
            statement.setString(3, a.getPassAbb());
            statement.setInt(4, a.getId_servizio());
            statement.setString (5, a.getDurata());
            statement.setDouble(6, a.getCosto());
            
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
	
	 public List<Abbonamento> getAllUtentiAbbonati() {
			List<Abbonamento> utenti = new ArrayList<Abbonamento>();
			String cf = null;
			String username = null;
			String passAbb=null;
			int id_servizio=0;
			String durata = null;
			double costo=0;
			Abbonamento a = null;
			
			Connection con = null;
			PreparedStatement statement = null;
	        ResultSet result = null;
	        
	        try {
	        	con = MySQLDAO.createConnection();
	        	statement = con.prepareStatement(READ_ALL_QUERY);
	 
	        	statement.execute();
	        	result = statement.getResultSet();
	        	
	        	while(result.next()) {
	        		cf = result.getString(1);
	        		username = result.getString(2);
	        		passAbb = result.getString(3);
	        		id_servizio = result.getInt(4);
	        		durata = result.getString(5);
	        		costo = result.getDouble(6);
	        		a = new Abbonamento(cf, username, passAbb, id_servizio, durata, costo);
	        		utenti.add(a);
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
	 
	 
	 public List<Abbonamento> getAllUtentiAbbonati1() {
			List<Abbonamento> utenti = new ArrayList<Abbonamento>();
			String cf = null;
			String username = null;
			String passAbb=null;
			int id_servizio=0;
			String durata = null;
			double costo=0;
			Abbonamento a = null;
			
			Connection con = null;
			PreparedStatement statement = null;
	        ResultSet result = null;
	        
	        try {
	        	con = MySQLDAO.createConnection();
	        	statement = con.prepareStatement(READ_ALL_QUERY1);
	 
	        	statement.execute();
	        	result = statement.getResultSet();
	        	
	        	while(result.next()) {
	        		cf = result.getString(1);
	        		username = result.getString(2);
	        		passAbb = result.getString(3);
	        		id_servizio = result.getInt(4);
	        		durata = result.getString(5);
	        		costo = result.getDouble(6);
	        		a = new Abbonamento(cf, username, passAbb, id_servizio, durata, costo);
	        		utenti.add(a);
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
	 
	 
	 
	 
	 public List<Libro> getLibriAbbonamento() {
			List<Libro> prodotti = new ArrayList<Libro>();
			Libro prodotto = null;
			Connection con = null;
			PreparedStatement statement = null;
	        ResultSet result = null;
	          	
	        try {
	        	con = MySQLDAO.createConnection();        	   	
	        	statement = con.prepareStatement(READ_LIBRI_ABBONAMENTO);
	        	statement.execute();
	        	result = statement.getResultSet();
	        	
	        	while(result.next()) {
	        		prodotto = new Libro(result.getString(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getInt(6),result.getString(7), result.getDouble(8), result.getInt(9), result.getBoolean(10), result.getBoolean(11), result.getString(12));
	        		
	        		prodotto.setPath("Cover/"+ prodotto.getIsbn() + ".jpg");
	        		prodotti.add(prodotto);
	        		
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
			return prodotti;
		}

	
	
	public List<Libro> getLibriAbbonamento1() {
		List<Libro> prodotti = new ArrayList<Libro>();
		Libro prodotto = null;
		Connection con = null;
		PreparedStatement statement = null;
        ResultSet result = null;
          	
        try {
        	con = MySQLDAO.createConnection();        	   	
        	statement = con.prepareStatement(READ_LIBRI_ABBONAMENTO1);
        	statement.execute();
        	result = statement.getResultSet();
        	
        	while(result.next()) {
        		prodotto = new Libro(result.getString(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getInt(6),result.getString(7), result.getDouble(8), result.getInt(9), result.getBoolean(10), result.getBoolean(11), result.getString(12));
        		
        		prodotto.setPath("Cover/"+ prodotto.getIsbn() + ".jpg");
        		prodotti.add(prodotto);
        		
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
		return prodotti;
	}
}
