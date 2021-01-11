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
 * Servlet implementation class UpdateAdminController
 */
@WebServlet("/UpdateAdminController")
public class UpdateAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private AdminDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminController() {
        dao = new AdminDAO();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int adminid = Integer.parseInt(request.getParameter("adminid"));
        Admin ad = dao.getAdminById(adminid); 
        request.setAttribute("admin", ad);
        RequestDispatcher view = request.getRequestDispatcher("UpdateAdmin.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin ad = new Admin();
		ad.setAdminid(Integer.parseInt(request.getParameter("adminid")));
		ad.setAdname(request.getParameter("adname"));
		ad.setAddress(request.getParameter("address"));
		ad.setAdemail(request.getParameter("ademail"));
		ad.setAdpass(request.getParameter("adpass"));
		ad.setAdphone(request.getParameter("adphone"));
		dao.updateAdmin(ad);
		
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
