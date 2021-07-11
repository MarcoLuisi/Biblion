package it.unisa.Biblion.Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.Biblion.DAO.AbbonamentoDAO;
import it.unisa.Biblion.Model.Abbonamento;
import it.unisa.Biblion.Model.Utente;

/**
 * Servlet implementation class LoginAbbonamento1
 */
@WebServlet("/LoginAbbonamento1")
public class LoginAbbonamento1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAbbonamento1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		synchronized(session) {
			
			String username = request.getParameter("username");
			String passAbb=request.getParameter("passAbb");
			String address;
			
			
			AbbonamentoDAO data = new AbbonamentoDAO();
			
			List<Abbonamento> utenti = data.getAllUtentiAbbonati1();
			
			Abbonamento user = null;
			
			for(Abbonamento e : utenti) {
				if(e.getUsername().compareToIgnoreCase(username) == 0
						&& e.getPassAbb().compareToIgnoreCase(passAbb)==0) {
						
					user = e;
				}
			}
			
			boolean logged;
			boolean wrong;
			

			session.setAttribute("userAbbonato1", user);
			
			
			if(user != null) {
				logged = true;
				session.setAttribute("isLogAbbonato1", logged);
				
				address = "libriAbbonamento1.jsp";
				
				request.getRequestDispatcher(address).forward(request, response);
			}
			
			else{
				wrong = true;
				session.setAttribute("isWrongAbbonato1", wrong);
				address = "loginAbbonamento1.jsp";
				request.getRequestDispatcher(address).forward(request, response);
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
