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
 * Servlet implementation class DeleteCourtController
 */
@WebServlet("/DeleteCourtController")
public class DeleteCourtController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourtDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 public DeleteCourtController() {
	    	super();
	        dao = new CourtDAO();
	    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")){
       String cid= request.getParameter("cid");
        dao.deleteCourts(cid);
        
        action = "ViewCourt.jsp";
        try {
			request.setAttribute("court", CourtDAO.getAllCourts());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
        RequestDispatcher view = request.getRequestDispatcher("ViewCourt.jsp");
        view.forward(request, response);
    }

}
