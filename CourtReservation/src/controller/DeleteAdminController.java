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

/**
 * Servlet implementation class DeleteAdminController
 */
@WebServlet("/DeleteAdminController")
public class DeleteAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private AdminDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAdminController() {
        super();
        dao = new AdminDAO();
        // TODO Auto-generated constructor stub
    }
    /**
   	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   	 */
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	    
           String action = request.getParameter("action");
           if (action.equalsIgnoreCase("delete")){
          int adminid= Integer.parseInt(request.getParameter("adminid"));
           dao.deleteAdmin(adminid);
           
           action = "ViewAdmin.jsp";
           try {
   			request.setAttribute("admin", AdminDAO.getAllAdmin());
   		} catch (ClassNotFoundException | SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
           }
           RequestDispatcher view = request.getRequestDispatcher("ViewAdmin.jsp");
           view.forward(request, response);
       }

   }
