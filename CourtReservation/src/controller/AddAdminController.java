package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import model.Admin;

/**
 * Servlet implementation class AddAdminController
 */
@WebServlet("/AddAdminController")
public class AddAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private AdminDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminController() {
        super();
        dao = new AdminDAO();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin ad = new Admin();

		ad.setAdname(request.getParameter("adname"));
		ad.setAddress(request.getParameter("address"));
		ad.setAdemail(request.getParameter("ademail"));
		ad.setAdpass(request.getParameter("adpass"));
		ad.setAdphone(request.getParameter("adphone"));
		
		dao.addAdmin(ad);
		
		try {
			request.setAttribute("admin", AdminDAO.getAllAdmin());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAdmin.jsp");
		dispatcher.forward(request, response);
	
	}

}


	


