package it.unisa.Biblion.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unisa.Biblion.Model.Libro;


public class LibroDAO {
	
	//quantita indica il numero di copie disponibili
	
	/** La query per l'inserimento di un nuovo prodotto */
    private static final String CREATE_QUERY = "INSERT INTO libro (isbn, quantita, titolo, editore, tipo, annoEdizione, genere, prezzo, pagine, ebook, audiolibro, autore) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    
    /** La query per la lettura di un singolo prodotto. */
    private static final String READ_QUERY = "SELECT * FROM libro WHERE and ebook = false and audiolibro = false and isbn = ?";
    
    private static final String OFFERTE = "Select * from libro where tipo = 'Nuovo' and prezzo < 5.50";
    /** La query per la lettura di un singolo prodotto. */
    private static final String READ_QUERY_TITLE = "SELECT * FROM libro where titolo = ?";
    
    
    private static final String READ_QUERY_VOLUME = "SELECT quantita FROM libro WHERE ebook = false and audiolibro = false and isbn = ?";
    
    private static final String READ_ALL = "SELECT * from libro";
    		
    /** La query per la lettura di tutti i prodotti cartacei. */
    private static final String READ_ALL_QUERY = "SELECT * from libro where ebook = false and audiolibro = false";
    
    /** La query per la lettura di tutti i prodotti in base al parametro genere */
    private static final String READ_ALL_QUERY_SPECIFIED = "SELECT * from libro where ebook = false and audiolibro = false and genere = ?";
    
    /** La query per la lettura di tutti i prodotti in base al parametro tipo(nuovo/usato) */
    private static final String READ_ALL_QUERY_SPECIFIED1 = "SELECT * from libro where ebook = false and audiolibro = false and tipo = ?";
    
    /** La query per l'aggiornamento di un singolo prodotto. */
    
    private static final String UPDATE_QUERY = "UPDATE libro SET quantita=?, titolo=?, editore=?, tipo=?, annoEdizione=?, genere=?, prezzo=?, pagine=?, ebook=?, audiolibro=?, autore=? WHERE isbn = ?";
   
    private static final String ADD_ONE = "UPDATE libro SET quantita = quantita + 1 WHERE isbn=?";
    
    private static final String DELETE_ONE = "UPDATE libro SET quantita = quantita - 1 WHERE isbn = ?";
    
    private static final String DELETE_BOOK = "DELETE FROM libro WHERE quantita = 0";
    
    private static final String DELETE_BOOK1 = "DELETE FROM libro WHERE titolo = ?";
    
    private static final String LIST_QUERY = "SELECT titolo, quantità FROM libro";
    
    
    
    private static final String READ_QUERY_EBOOK = "SELECT * FROM libro WHERE ebook = true and isbn = ?";
    private static final String READ_QUERY_TITLE_EBOOK="SELECT * FROM libro where ebook = true and titolo=?";
    private static final String READ_ALL_QUERY_EBOOK="SELECT * FROM libro where ebook=true";
    private static final String READ_ALL_QUERY_SPECIFIED_EBOOK = "SELECT * from libro where ebook = true and genere = ?";
  
    private static final String READ_QUERY_AUDIOLIBRO = "SELECT * FROM  libro WHERE audiolibro = true and isbn = ?";
    private static final String READ_QUERY_TITLE_AUDIOLIBRO="SELECT * FROM libro where audiolibro = true and titolo=?";
    private static final String READ_ALL_QUERY_AUDIOLIBRO="SELECT * FROM libro where audiolibro=true";
    private static final String READ_ALL_QUERY_SPECIFIED_AUDIOLIBRO = "SELECT * from libro where audiolibro = true and genere = ?";
  
    public List<Libro> getAllProdotto() {
		List<Libro> prodotti = new ArrayList<Libro>();
		Libro prodotto = null;
		Connection con = null;
		PreparedStatement statement = null;
        ResultSet result = null;
          	
        try {
        	con = MySQLDAO.createConnection();        	   	
        	statement = con.prepareStatement(READ_ALL_QUERY);
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
    
    public List<Libro> getAllLibri() {
		List<Libro> prodotti = new ArrayList<Libro>();
		Libro prodotto = null;
		Connection con = null;
		PreparedStatement statement = null;
        ResultSet result = null;
          	
        try {
        	con = MySQLDAO.createConnection();        	   	
        	statement = con.prepareStatement(READ_ALL);
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
    
    public Libro getProdotto(String isbn) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Libro l=null;
		
		 try {
	            con = MySQLDAO.createConnection();
	            statement = con.prepareStatement(READ_QUERY);
	            statement.setString(1, isbn);
	            statement.execute();
	            
	            while(result.next()) {
	            	l = new Libro(result.getString(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getInt(6),result.getString(7), result.getDouble(8), result.getInt(9), result.getBoolean(10), result.getBoolean(11), result.getString(12));
	            	l.setPath("Cover/"+ l.getIsbn() + ".jpg");
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
	 	
		return l;
	}
    
    public boolean createProdotto(Libro prodotto) {
		Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(CREATE_QUERY);
            
            statement.setString(1, prodotto.getIsbn());
            statement.setInt(2, prodotto.getQuantita());
           
            statement.setString(3, prodotto.getTitolo());
            statement.setString(4, prodotto.getEditore());
            
            if (prodotto.getTipo().equals("")) {
            	statement.setNull(5,  java.sql.Types.VARCHAR);
            }
            
            else statement.setString(5, prodotto.getTipo());
            
            
            statement.setInt(6, prodotto.getAnnoEdizione());
            statement.setString(7,prodotto.getGenere());
            statement.setDouble(8, prodotto.getPrezzo());
            statement.setInt(9, prodotto.getPagine());
            statement.setBoolean(10, prodotto.isEbook());
            
            statement.setBoolean(11, prodotto.isAudiolibro());
            statement.setString(12, prodotto.getAutore());
            statement.execute();
            
            int check = statement.executeUpdate();
            
            if (check > 0) {
            	return true;
            }
            
            else return false;
            
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
 
        return false;
	}
    
    
    
    public boolean updateProdotto(String isbn, int quantita, String titolo, String editore,
    											String tipo, int annoEdizione, String genere, double prezzo, 
    											int pagine, boolean eb, boolean a, String autore) {
		Connection con = null;
        PreparedStatement statement = null;
        try {
        	con = MySQLDAO.createConnection();
        	statement = con.prepareStatement(UPDATE_QUERY);
        	statement.setInt(1, quantita);
            statement.setString(2, titolo);
            statement.setString(3, editore);
            
            if (tipo.equals("")) {
            	statement.setNull(4,  java.sql.Types.VARCHAR);
            }
            
           
            else statement.setString(4, tipo);
            
            statement.setInt(5, annoEdizione);
            
            statement.setString(6, genere);
            statement.setDouble(7,prezzo);
            statement.setInt(8, pagine);
          
            statement.setBoolean(9,eb);
            statement.setBoolean(10, a);
            statement.setString(11, autore);
            statement.setString(12, isbn);
        	statement.executeUpdate();
            return true;
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
    
    public boolean deleteProdotto() {
  		Connection con = null;
          PreparedStatement statement = null;
          try {
              con = MySQLDAO.createConnection();
              statement = con.prepareStatement(DELETE_BOOK);
            
              statement.executeUpdate();
              return true;
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
    
    public boolean deleteProdotto1(String titolo) {
		Connection con = null;
        PreparedStatement statement = null;
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(DELETE_BOOK1);
            statement.setString(1, titolo);
            statement.executeUpdate();
            return true;
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
    
    public List<Libro> getProdottiSpecifici(String genere) {
		List<Libro> prodotti = new ArrayList<Libro>();
		Libro prodotto = null;
		Connection con = null;
		PreparedStatement statement = null;
        ResultSet result = null;
          	
        try {
        	con = MySQLDAO.createConnection();        	   	
        	statement = con.prepareStatement(READ_ALL_QUERY_SPECIFIED);
        	statement.setString(1, genere);
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
    
    public List<Libro> getProdottiSpecifici1(String tipo) {
		List<Libro> prodotti = new ArrayList<Libro>();
		Libro prodotto = null;
		Connection con = null;
		PreparedStatement statement = null;
        ResultSet result = null;
          	
        try {
        	con = MySQLDAO.createConnection();        	   	
        	statement = con.prepareStatement(READ_ALL_QUERY_SPECIFIED1);
        	statement.setString(1, tipo);
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
    
    
    public int ceckVolume(String isbn) {
		Connection con = null;
		PreparedStatement statement =null;
		ResultSet result = null;
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(READ_QUERY_VOLUME);
			
			statement.setString(1,isbn);
	
			statement.execute();
			
			result = statement.getResultSet();
			
			while(result.next()) {
				return result.getInt(1);
			}

			
		}catch (SQLException e) {
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
		
		return -1;
	}
    
    
   
    public boolean removeBookOne(String isbn) {
		Connection con = null;
		PreparedStatement statement = null;
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(DELETE_ONE);
			
			statement.setString(1, isbn);
			
			statement.executeUpdate();
			
			return true;

			
		}catch (SQLException e) {
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
    
    public Libro searchTitle(String titolo) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(READ_QUERY_TITLE);
			
			statement.setString(1, titolo);
			
			statement.execute();
			
			result = statement.getResultSet();
			 while(result.next()) {
				
				 Libro l =new Libro(result.getString(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getInt(6),result.getString(7), result.getDouble(8), result.getInt(9),result.getBoolean(10), result.getBoolean(11), result.getString(12));
				 l.setPath("Cover/"+ l.getIsbn() + ".jpg");
				 return l;
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
		
		return null;
	}
    
    
    public List<Libro> getAllProdottoEbook() {
		List<Libro> prodotti = new ArrayList<Libro>();
		Libro prodotto = null;
		Connection con = null;
		PreparedStatement statement = null;
        ResultSet result = null;
          	
        try {
        	con = MySQLDAO.createConnection();        	   	
        	statement = con.prepareStatement(READ_ALL_QUERY_EBOOK);
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
    
    public List<Libro> getAllProdottoAudiolibro() {
		List<Libro> prodotti = new ArrayList<Libro>();
		Libro prodotto = null;
		Connection con = null;
		PreparedStatement statement = null;
        ResultSet result = null;
          	
        try {
        	con = MySQLDAO.createConnection();        	   	
        	statement = con.prepareStatement(READ_ALL_QUERY_AUDIOLIBRO);
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
    
    public Libro getProdottoEbook(String isbn) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Libro l=null;
		
		 try {
	            con = MySQLDAO.createConnection();
	            statement = con.prepareStatement(READ_QUERY_EBOOK);
	            statement.setString(1, isbn);
	            statement.execute();
	            
	            while(result.next()) {
	            	l = new Libro(result.getString(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getInt(6),result.getString(7), result.getDouble(8), result.getInt(9), result.getBoolean(10), result.getBoolean(11), result.getString(12));
	            	l.setPath("Cover/"+ l.getIsbn() + ".jpg");
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
	 	
		return l;
	}
    
    public Libro getProdottoAudiolibro(String isbn) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Libro l=null;
		
		 try {
	            con = MySQLDAO.createConnection();
	            statement = con.prepareStatement(READ_QUERY_AUDIOLIBRO);
	            statement.setString(1, isbn);
	            statement.execute();
	            
	            while(result.next()) {
	            	l = new Libro(result.getString(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getInt(6),result.getString(7), result.getDouble(8), result.getInt(9), result.getBoolean(10), result.getBoolean(11), result.getString(12));
	            	l.setPath("Cover/"+ l.getIsbn() + ".jpg");
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
	 	
		return l;
	}
    
    public List<Libro> getProdottiSpecificiEbook(String genere) {
		List<Libro> prodotti = new ArrayList<Libro>();
		Libro prodotto = null;
		Connection con = null;
		PreparedStatement statement = null;
        ResultSet result = null;
          	
        try {
        	con = MySQLDAO.createConnection();        	   	
        	statement = con.prepareStatement(READ_ALL_QUERY_SPECIFIED_EBOOK);
        	statement.setString(1, genere);
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
    
    public List<Libro> getProdottiSpecificiAudiolibro(String genere) {
		List<Libro> prodotti = new ArrayList<Libro>();
		Libro prodotto = null;
		Connection con = null;
		PreparedStatement statement = null;
        ResultSet result = null;
          	
        try {
        	con = MySQLDAO.createConnection();        	   	
        	statement = con.prepareStatement(READ_ALL_QUERY_SPECIFIED_AUDIOLIBRO);
        	statement.setString(1, genere);
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
    
    
    public Libro searchTitleEbook(String titolo) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(READ_QUERY_TITLE_EBOOK);
			
			statement.setString(1, titolo);
			
			statement.execute();
			
			result = statement.getResultSet();
			 while(result.next()) {
				 return new Libro(result.getString(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getInt(6),result.getString(7), result.getDouble(8), result.getInt(9),result.getBoolean(10), result.getBoolean(11), result.getString(12));
				 
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
		
		return null;
	}
    
    public Libro searchTitleAudiolibro(String titolo) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(READ_QUERY_TITLE_AUDIOLIBRO);
			
			statement.setString(1, titolo);
			
			statement.execute();
			
			result = statement.getResultSet();
			 while(result.next()) {
				 return new Libro(result.getString(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getInt(6),result.getString(7), result.getDouble(8), result.getInt(9),result.getBoolean(10), result.getBoolean(11), result.getString(12));
				 
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
		
		return null;
	}
    
    public List<Libro> getAllOfferte() {
		List<Libro> prodotti = new ArrayList<Libro>();
		Libro prodotto = null;
		Connection con = null;
		PreparedStatement statement = null;
        ResultSet result = null;
          	
        try {
        	con = MySQLDAO.createConnection();        	   	
        	statement = con.prepareStatement(OFFERTE);
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
