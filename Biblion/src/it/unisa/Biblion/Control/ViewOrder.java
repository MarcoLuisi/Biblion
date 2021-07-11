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

import it.unisa.Biblion.DAO.OrdineDAO;



/**
 * Servlet implementation class ViewOrder
 */
@WebServlet("/ViewOrder")
public class ViewOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		synchronized(session) {
			OrdineDAO ordine = new OrdineDAO();
			List<it.unisa.Biblion.Model.Ordine> view = new ArrayList<it.unisa.Biblion.Model.Ordine>();
			
			String username = request.getParameter("nome_utente");
			String datastart = request.getParameter("datastart");
			String dataend = request.getParameter("dataend");
			

			if(datastart == null || datastart == "") {
				datastart = "2000-01-01";
			}
			
			if(dataend == null || dataend == "") {
				dataend = "3000-01-01";
			}
			
			
			view = ordine.orderAdmin(username, datastart, dataend);

			
			session.setAttribute("orderUserList", view);
			
			request.getRequestDispatcher("storicoordini.jsp").forward(request, response);
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
