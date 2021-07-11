package it.unisa.Biblion.Control;

import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.Biblion.Model.CartLibro;


/**
 * Servlet implementation class Remove_one
 */
@WebServlet("/Remove_one")
public class Remove_one extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Remove_one() {
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
			String titolo = request.getParameter("titolo");
			@SuppressWarnings("unchecked")
			List<CartLibro> cartList = (List<CartLibro>) session.getAttribute("cart");
			
			try {
				for(CartLibro e : cartList) {
					if(e.getTitolo().compareToIgnoreCase(titolo) == 0)
						e.setQuantita((e.getQuantita() - 1));
					if(e.getQuantita() == 0) {
						cartList.remove(e);
						if(cartList.size() == 0) {
							request.getRequestDispatcher("Index.jsp").forward(request, response);

						}
					}
				}
			} catch (ConcurrentModificationException e){
				request.getRequestDispatcher("carrello.jsp").forward(request, response);
				
			}
			
			
			session.setAttribute("cart", cartList);
			request.getRequestDispatcher("carrello.jsp").forward(request, response);	
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
