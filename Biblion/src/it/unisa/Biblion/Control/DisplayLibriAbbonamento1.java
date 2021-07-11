package it.unisa.Biblion.Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.unisa.Biblion.DAO.AbbonamentoDAO;
import it.unisa.Biblion.Model.Libro;

/**
 * Servlet implementation class DisplayLibriAbbonamento1
 */
@WebServlet("/DisplayLibriAbbonamento1")
public class DisplayLibriAbbonamento1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayLibriAbbonamento1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AbbonamentoDAO prodotto = new AbbonamentoDAO();
		
		List<Libro> prodotti = prodotto.getLibriAbbonamento1();
		PrintWriter out = response.getWriter();

		String json = new Gson().toJson(prodotti);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(json);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
