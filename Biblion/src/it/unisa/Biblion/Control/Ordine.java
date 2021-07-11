package it.unisa.Biblion.Control;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import it.unisa.Biblion.DAO.LibroDAO;
import it.unisa.Biblion.DAO.OrdineDAO;
import it.unisa.Biblion.DAO.UtenteDAO;
import it.unisa.Biblion.Model.CartLibro;
import it.unisa.Biblion.Model.Libro;
import it.unisa.Biblion.Model.Utente;




/**
 * Servlet implementation class Ordine
 */
@WebServlet("/Ordine")
public class Ordine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ordine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		synchronized(session) {
			@SuppressWarnings("unchecked")
			List<CartLibro> cartList = (List<CartLibro>) session.getAttribute("cart");
			Utente user=(Utente) session.getAttribute("user");

			
			if(cartList == null) {
				cartList = new ArrayList<CartLibro>();
			}
			
			List<String> nonDisponibili = new ArrayList<String>();
			
			String result = "";
			
			OrdineDAO ordine = new OrdineDAO();
			LibroDAO prodotto = new LibroDAO();
			List<Libro> prodotti = prodotto.getAllLibri();

			double totale = 0;
			
			if(cartList.size() == 0 ) {
				result = "Carrello vuoto";
			}else {
				for(CartLibro e : cartList) {
					for(Libro x : prodotti) {
						if(e.getIsbnLibro().equals(x.getIsbn())) {
							if(e.getQuantita() > x.getQuantita()) {
								nonDisponibili.add(x.getTitolo());
							}
						}
					}
				}
				
			}
			
			if(nonDisponibili.size() > 0) {
				for(String e : nonDisponibili) {
					result = result + e + ", ";
				}
				result = result + "quantità non disponibile per il prodotto selezionato";
			}else if(cartList.size() >= 1){
				
				for(CartLibro e : cartList) {
					totale = totale + e.getPrezzo() * e.getQuantita();
				}
				
				
				 
					result = "Ordine creato";
					
					ordine.creazioneOrdine(user.getCf(), totale, cartList);
					
		
					cartList.removeAll(cartList);
				
			}
			
			PrintWriter out = response.getWriter();

			String json = new Gson().toJson(result);
			
			UtenteDAO data = new UtenteDAO();
			
			List<Utente> utenti = data.getAllUtenti();
			
			
			for(Utente e : utenti) {
				if(e.getNomeutente().compareToIgnoreCase(user.getNomeutente()) == 0
						&& e.getPassword().compareToIgnoreCase(user.getPassword()) == 0) {
					user = e;
				}
			}
			
			session.setAttribute("user", user);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(json);
			out.flush();

		}
		
	}
			

	  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
