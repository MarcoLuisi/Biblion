package it.unisa.Biblion.Model;

public class Ordine {

	private int idordine;
	private String titolo;
	private int quantita;
	private double prezzo;
	private String data;
	private String dataConsegna;
	private String tipo;
	
	
	private String cf;
	private double prezzoTotale;
	
	public Ordine(int idordine, String titolo, int quantita, double prezzo, String data, String dc, String t, String cf, double prezzoTotale) {
		
		this.idordine = idordine;
		this.titolo = titolo;
		this.quantita = quantita;
		this.prezzo = prezzo;
		this.data = data;
		this.dataConsegna= dc;
		this.tipo =t;
		this.cf=cf;
		this.prezzoTotale=prezzoTotale;
	}
	
	public Ordine() {
		super();
	}
	
	/**
	 * @return the idordine
	 */
	public int getIdordine() {
		return idordine;
	}
	/**
	 * @param idordine the idordine to set
	 */
	public void setIdordine(int idordine) {
		this.idordine = idordine;
	}
	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}
	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	/**
	 * @return the prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}
	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * @return the volume
	 */
	public int getQuantita() {
		return quantita;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setQuantita(int volume) {
		this.quantita = volume;
	}

	
	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public double getPrezzoTotale() {
		return prezzoTotale;
	}

	public void setPrezzoTotale(double prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}

	public String getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(String dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
