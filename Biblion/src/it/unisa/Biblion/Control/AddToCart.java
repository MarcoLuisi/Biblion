package it.unisa.Biblion.Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.Biblion.DAO.LibroDAO;
import it.unisa.Biblion.Model.CartLibro;
import it.unisa.Biblion.Model.Libro;



/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		synchronized(session) {
			String isbn = request.getParameter("isbn");
			
			boolean presenteinLista = false;

			LibroDAO prodotto = new LibroDAO();
			List<Libro> prodotti = prodotto.getAllLibri();
			
			
			@SuppressWarnings("unchecked")
			List<CartLibro> cartList = (List<CartLibro>) session.getAttribute("cart");
			if(cartList == null) {
				cartList = new ArrayList<CartLibro>();
				
			}
			
			Boolean isLogged = (Boolean) session.getAttribute("isLog");
			
			if(isLogged != null) {

				for(Libro e : prodotti) {
					
					if(e.getIsbn().equals(isbn)) {
						for(CartLibro x : cartList) {
							if(x.getIsbnLibro().equals(isbn)) {
								presenteinLista = true;
								x.setQuantita((x.getQuantita() + 1));
							}
						}
					
						if(!presenteinLista) {
							
							String tipo= "";
							
							if (e.isAudiolibro()) {
								tipo = "Audiolibro";
							}
							
							else if (e.isEbook()) {
								tipo ="Ebook";
							}
							
							else tipo = e.getTipo();
							
							cartList.add(new CartLibro(e.getIsbn(), e.getTitolo(), e.getPrezzo(), 1, tipo));
							
						}
					}
				}
				
				session.setAttribute("cart", cartList);
				request.getRequestDispatcher("Index.jsp").forward(request, response);	
			} else {
				request.getRequestDispatcher("login.jsp").forward(request, response);	
			} 
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
