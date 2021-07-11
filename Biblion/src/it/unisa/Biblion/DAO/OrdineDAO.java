package it.unisa.Biblion.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import it.unisa.Biblion.Model.*;




public class OrdineDAO {
	
	private static String CREATE_ORDER = "INSERT INTO ordine (dataInserimento, dataConsegna, cf_utente, costo_totale) VALUES (?, ?, ?, ?);";
	private static String ADD_PRODUCT = "INSERT INTO voce_ordine (id_ordine, isbn,tipo, quantita, prezzo ) VALUES (?, ? , ?, ?,?)";
	//private static String REMOVE_BUY = "UPDATE voce_ordine SET quantità = quantità - 1 WHERE isbn = ? LIMIT 1;";
	//private static String REMOVE_0 = "DELETE FROM voce_ordine WHERE quantità = 0 AND id_ordine = ?";
	//private static String SELECT_USER = "select cf_utente, prezzo, v.id_ordine from voce_ordine v, ordine o WHERE v.id_ordine = o.id_ordine and v.isbn= = ? LIMIT 1";
	private static String PRODUCT_BUY="select o.id_ordine, l.titolo,  v.quantita, v.prezzo,  o.dataInserimento, o.dataConsegna,v.tipo, o.cf_utente, o.costo_totale from  voce_ordine v, libro l, ordine o where o.id_ordine = v.id_ordine and v.isbn = l.isbn and o.cf_utente=?";
	private static String VIEW_ORDER = "select o.id_ordine, l.titolo,  v.quantita, v.prezzo, o.dataInserimento, o.dataConsegna, v.tipo,u.nomeUtente, o.costo_totale \r\n" + 
			"from  voce_ordine v, utente u, libro l, ordine o \r\n" + 
			"where o.id_ordine = v.id_ordine and v.isbn = l.isbn and o.cf_utente = u.cf and u.nomeUtente =?"
			+ " and ? < o.dataInserimento AND ? > o.dataInserimento";
	
	@SuppressWarnings("null")
	public int creazioneOrdine(String cf , double prezzo_totale, List<CartLibro> prodotti) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		LibroDAO l = new LibroDAO();
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(CREATE_ORDER, Statement.RETURN_GENERATED_KEYS);
			int id_ordine = 0;
			String cf_utente = null;
			double prezzo = 0;
			
			//Creazione ordine
			String data = LocalDateTime.now().toInstant(ZoneOffset.UTC).toString();
			String dataC =  LocalDateTime.now().plusDays(5).toInstant(ZoneOffset.UTC).toString();
	
			statement.setString(1, data.substring(0, 10));
			statement.setString(2, dataC.substring(0, 10));
			statement.setString(3, cf);
			statement.setDouble(4, prezzo_totale);

		
            int check = statement.executeUpdate();
           
            if (check>0) {
                result = statement.getGeneratedKeys();
                result.next();
                id_ordine = result.getInt(1);
            }
            
            statement.close();
            result.close();
            
            
            
            //Aggiunta dei prodotti
            for(CartLibro e : prodotti) {
            	statement = con.prepareStatement(ADD_PRODUCT);
                statement.setInt(1, id_ordine);
                statement.setString(2, e.getIsbnLibro());
                statement.setString(3, e.getTipo());
                statement.setInt(4, e.getQuantita());
                statement.setDouble(5,e.getPrezzo());
                
                statement.execute();
                statement.close();
            }
            
            
            //Rimuovi prodotti
            for(CartLibro e : prodotti) {
            	int i = e.getQuantita();

            	
            	while(i > 0) {
            		
            		
            		l.removeBookOne(e.getIsbnLibro());
            		
            		if (l.ceckVolume(e.getIsbnLibro())==0) {
            			l.deleteProdotto1(e.getTitolo());
            		}
            
                    i--;                    
            	}
            }
            
           

            return 1;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		return -1;
		
	}
	
	public List<Ordine> acquisti(Utente user) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Ordine> ordini = new ArrayList<Ordine>();
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(PRODUCT_BUY);
			statement.setString(1, user.getCf());
			
			statement.execute();
			
			result = statement.getResultSet();
			
		
			while(result.next()) {
				ordini.add(new Ordine(result.getInt(1), result.getString(2), result.getInt(3), result.getDouble(4), result.getString(5),result.getString(6), result.getString(7), result.getString(8), result.getDouble(9)));
			}
			
			/*
			for (int i=0; i<ordini.size(); i++) {
				System.out.println(ordini.get(i).getIdordine());
				System.out.println(ordini.get(i).getTitolo());
				System.out.println(ordini.get(i).getQuantita());
				System.out.println(ordini.get(i).getPrezzo());
				System.out.println(ordini.get(i).getData());
				System.out.println(ordini.get(i).getCf());
				System.out.println(ordini.get(i).getPrezzoTotale());
			}
			*/
			
			return ordini;
			

		} catch (SQLException e) {
            e.printStackTrace();
        } 
		
		
		return null;
	}

	public List<Ordine> orderAdmin(String username, String startdate, String endDate) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Ordine> view = new ArrayList<Ordine>();
		
		try {
			con = MySQLDAO.createConnection();
			statement = con.prepareStatement(VIEW_ORDER);
			statement.setString(1, username);
			statement.setString(2, startdate);
			statement.setString(3, endDate);



			statement.execute();
			
			result = statement.getResultSet();
			
			while(result.next()) {
				view.add(new Ordine(result.getInt(1), result.getString(2), result.getInt(3), result.getDouble(4), result.getString(5), result.getString(6), result.getString(7), result.getString(8), result.getDouble(9)));
			}
			
			return view;
			

		} catch (SQLException e) {
            e.printStackTrace();
        } 
		
				return null;
	}

	
}
