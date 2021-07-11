package it.unisa.Biblion.Model;

public class Utente {
	
	private String cf;
	private String nome;
	private String cognome;
	private String password;
	private String email;
	private String nomeutente;
	private String indirizzo;
	private boolean admin;
   
	public Utente () {
		
		super();
		
	}
	
	public Utente (String cf, String n, String c
			,String p, String e, String nu, String i, boolean a) {
		
		this.cf = cf;
	    nome = n;
	    cognome = c;
	    password = p;
	    email = e;
	    nomeutente = nu;
	    indirizzo = i;
	    admin = a;
	}
	
	

	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNomeutente() {
		return nomeutente;
	}
	public void setNomeutente(String nomeutente) {
		this.nomeutente = nomeutente;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
