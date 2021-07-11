package it.unisa.Biblion.Model;

public class CartLibro {
	
	private String isbnLibro;
	private String titolo;
	private double prezzo;
	private int quantita;
	private String tipo;
	
	public CartLibro() {
		super();
	}
	
	public CartLibro(String isbn, String tit, double p, int q, String t){
		this.isbnLibro=isbn;
		this.titolo=tit;
		this.prezzo=p;
		this.quantita=q;
		this.tipo=t;
		
	}
	
	
	public String getIsbnLibro() {
		return isbnLibro;
	}
	public void setIsbnLibro(String isbnLibro) {
		this.isbnLibro = isbnLibro;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

}
