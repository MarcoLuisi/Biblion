package it.unisa.Biblion.Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.Biblion.DAO.LibroDAO;
import it.unisa.Biblion.Model.Libro;

/**
 * Servlet implementation class AddBookAdmin
 */
@WebServlet("/AddBookAdmin")
public class AddBookAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LibroDAO l = new LibroDAO();
		
		boolean ebook = false, audiolibro = false;
		String tipo="";
		
		String isbn = request.getParameter("isbn");
		int quantita=Integer.parseInt(request.getParameter("quantita"));
		String titolo = request.getParameter("titolo");
		String editore = request.getParameter("editore");
		int annoEdizione = Integer.parseInt(request.getParameter("annoEdizione"));
		String genere = request.getParameter("genere");
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		int pagine = Integer.parseInt(request.getParameter("pagine"));
		String tipologia = request.getParameter("tipologia");
		String autore = request.getParameter("autore");
		
		if ("nuovo".equals(tipologia)) {
		    ebook = false;
		    audiolibro = false;
		    tipo = "nuovo";
		} 
		
		if ("usato".equals(tipologia)) {
		    ebook = false;
		    audiolibro = false;
		    tipo = "usato";
		} 
		
		if ("ebook".equals(tipologia)) {
		   ebook = true;
		   audiolibro = false;
		}
		
		if ("audiolibro".equals(tipologia)) {
			ebook = false;
			audiolibro = true;
		}
		
		
		
		l.createProdotto(new Libro(isbn,quantita, titolo, editore, tipo, annoEdizione, genere, prezzo, pagine, ebook, audiolibro, autore));
		
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
