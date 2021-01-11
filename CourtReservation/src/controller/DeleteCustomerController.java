package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import model.Customer;

/**
 * Servlet implementation class DeleteCustomerController
 */
@WebServlet("/DeleteCustomerController")
public class DeleteCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CustomerDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomerController() {
        super();
        dao = new CustomerDAO();
        // TODO Auto-generated constructor stub
    }

    /**
  	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  	 */
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	    
          String action = request.getParameter("action");
          if (action.equalsIgnoreCase("delete")){
         int custid= Integer.parseInt(request.getParameter("custid"));
          dao.deleteCustomer(custid);
          
          action = "ViewCustomer.jsp";
          try {
  			request.setAttribute("customer", CustomerDAO.getAllCustomer());
  		} catch (ClassNotFoundException | SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
          }
          RequestDispatcher view = request.getRequestDispatcher("ViewCustomer.jsp");
          view.forward(request, response);
      }

  }
