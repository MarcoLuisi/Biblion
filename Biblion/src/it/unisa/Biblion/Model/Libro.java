package it.unisa.Biblion.Model;

public class Libro {
	
		
		private String isbn;
		private int quantita;
		private String titolo;
		private String editore;
		private String tipo;
		private int annoEdizione;
		private String genere;
		private	double prezzo;
		private int pagine;
		private String path;
		private boolean ebook;
		private boolean audiolibro;
		private String autore;
		
	
		
		public Libro(String i, int q,  String tit, String e, String tip, int a, String g, double pre, int pag, boolean ebook, boolean audiolibro, String autore) {
			isbn=i;
			this.quantita=q;
			titolo=tit;
			editore = e;
			tipo = tip;
			annoEdizione = a;
			genere = g;
			prezzo = pre;
			pagine = pag;
			this.ebook=ebook;
			this.audiolibro=audiolibro;
		    this.setAutore(autore);
		}
		
		public Libro() {
		   super();
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public String getTitolo() {
			return titolo;
		}

		public void setTitolo(String titolo) {
			this.titolo = titolo;
		}

		public String getEditore() {
			return editore;
		}

		public void setEditore(String editore) {
			this.editore = editore;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public int getAnnoEdizione() {
			return annoEdizione;
		}

		public void setAnnoEdizione(int annoEdizione) {
			this.annoEdizione = annoEdizione;
		}

		public String getGenere() {
			return genere;
		}

		public void setGenere(String genere) {
			this.genere = genere;
		}

		public double getPrezzo() {
			return prezzo;
		}

		public void setPrezzo(double prezzo) {
			this.prezzo = prezzo;
		}

		public int getPagine() {
			return pagine;
		}

		public void setPagine(int pagine) {
			this.pagine = pagine;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public int getQuantita() {
			return quantita;
		}

		public void setQuantita(int quantita) {
			this.quantita = quantita;
		}

		public boolean isAudiolibro() {
			return audiolibro;
		}

		public void setAudiolibro(boolean audiolibro) {
			this.audiolibro = audiolibro;
		}

		public boolean isEbook() {
			return ebook;
		}

		public void setEbook(boolean ebook) {
			this.ebook = ebook;
		}

		public String getAutore() {
			return autore;
		}

		public void setAutore(String autore) {
			this.autore = autore;
		}
		
}
