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
 * Servlet implementation class AddCustomerController
 */
@WebServlet("/AddCustomerController")
public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CustomerDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerController() {
    	super();
		dao = new CustomerDAO();
        // TODO Auto-generated constructor stub
    }

	

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer cust = new Customer();

		cust.setCustname(request.getParameter("custname"));
		cust.setCustaddress(request.getParameter("custaddress"));
		cust.setCustemail(request.getParameter("custemail"));
		cust.setCustpass(request.getParameter("custpass"));
		cust.setCustphone(request.getParameter("custphone"));
		
		dao.addCustomer(cust);
		
		try {
			request.setAttribute("customer", CustomerDAO.getAllCustomer());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewCustomer.jsp");
		dispatcher.forward(request, response);
	
}

}

