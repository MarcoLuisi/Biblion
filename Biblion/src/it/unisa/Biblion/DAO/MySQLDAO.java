package it.unisa.Biblion.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAO {

	/** la classe driver */
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    /** Nome schema database */
    public static final String SCHEMA = "libreria";
    /** Eventuali opzioni per il connettore JDBC */
    public static final String OPTIONS = "?serverTimezone=UTC";
    /** L'url al database */
    public static final String DBURL = "jdbc:mysql://localhost:3306/" + SCHEMA + OPTIONS;
    /** Lo username per le operazioni sul DB  */
    public static final String USER = "root";
    /** La password per le operazioni sul DB */
    public static final String PASS = "abcd11";
    
    /**
     * Metodo per creare una connessione sul DB MySQL
     * 
     * @return l'oggetto Connection.
     */
    public static Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DBURL, USER, PASS);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
        return conn;
    }
}
