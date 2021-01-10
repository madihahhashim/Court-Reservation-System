package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourtDAO;
import model.Courts;

/**
 * Servlet implementation class addBookingController
 */
@WebServlet("/AddCourtController")
public class AddCourtController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourtDAO dao;
	
	public AddCourtController()
	{
		super();
		dao = new CourtDAO();
	}
	

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			Courts co = new Courts();
			
			co.setCid(request.getParameter("cid"));
			co.setCname(request.getParameter("cname"));
			co.setStatus(request.getParameter("status"));
			dao.addCourt(co);
			
			try {
				request.setAttribute("court", CourtDAO.getAllCourts());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewCourt.jsp");
			dispatcher.forward(request, response);
		
	}

}

