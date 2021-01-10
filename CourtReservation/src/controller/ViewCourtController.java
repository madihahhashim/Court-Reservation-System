package controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.CourtDAO;
import model.Courts;
/**
 * Servlet implementation class ViewCourtController
 */
@WebServlet("/ViewCourtController")
public class ViewCourtController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	 /**
	    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	    */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	try {
	    		List<Courts> co = CourtDAO.getAllCourts();
				request.setAttribute("court", co);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewCourt.jsp");
			dispatcher.forward(request, response);
	    }
	}

