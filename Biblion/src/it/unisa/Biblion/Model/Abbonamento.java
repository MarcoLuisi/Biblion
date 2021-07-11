package it.unisa.Biblion.Model;

public class Abbonamento {
	
	private String cf_utente;
	private String username;
	private String passAbb;
	private int id_servizio;
	private String durata;
	private double costo;
	
	public Abbonamento (String cf, String u, String p, int id, String d, double c) {
		this.cf_utente=cf;
		this.setUsername(u);
		this.setPassAbb(p);
		this.id_servizio=id;
		this.durata = d;
		this.costo = c;
		
	}
	
	public String getCf_utente() {
		return cf_utente;
	}
	public void setCf_utente(String cf_utente) {
		this.cf_utente = cf_utente;
	}
	public int getId_servizio() {
		return id_servizio;
	}
	public void setId_servizio(int id_servizio) {
		this.id_servizio = id_servizio;
	}
	public String getDurata() {
		return durata;
	}
	public void setDurata(String durata) {
		this.durata = durata;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassAbb() {
		return passAbb;
	}

	public void setPassAbb(String passAbb) {
		this.passAbb = passAbb;
	}

}
