package it.unisa.Biblion.Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.Biblion.DAO.*;
import it.unisa.Biblion.Model.Abbonamento;

/**
 * Servlet implementation class Registrazione1
 */
@WebServlet("/Registrazione1")
public class Registrazione1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrazione1() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AbbonamentoDAO data = new AbbonamentoDAO();
		UtenteDAO u = new UtenteDAO();
		
		String cf = request.getParameter("cf");
		String username = request.getParameter("username");
		String passAbb = request.getParameter("passAbb");
		
		String durata = request.getParameter("durata");
		double prezzo = 0;
		
		String indirizzo = "";
		
		if (durata.equals("mensile")) {
			prezzo = 3.50;
		}
		
		if (durata.equals("annuale")) {
			prezzo = 12.50;
		}
		
		if (u.checkCF(cf)==false) {
			indirizzo = "registrazione.html";
		}
		
		if (u.checkCF(cf) == true) {
			indirizzo = "loginAbbonamento.jsp";
			data.createAbbonamento(new Abbonamento(cf, username, passAbb, 1,  durata, prezzo));
		}
		
		
		request.getRequestDispatcher(indirizzo).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
