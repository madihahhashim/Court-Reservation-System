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
 * Servlet implementation class UpdateCustomerController
 */
@WebServlet("/UpdateCustomerController")
public class UpdateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CustomerDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerController() {
    	 dao = new CustomerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custid = Integer.parseInt(request.getParameter("custid"));
        Customer cu = dao.getCustomerById(custid); 
        request.setAttribute("customer", cu);
        RequestDispatcher view = request.getRequestDispatcher("UpdateCustomer.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer cust = new Customer();
		cust.setCustid(Integer.parseInt(request.getParameter("custid")));
		cust.setCustname(request.getParameter("custname"));
		cust.setCustaddress(request.getParameter("custaddress"));
		cust.setCustemail(request.getParameter("custemail"));
		cust.setCustpass(request.getParameter("custpass"));
		cust.setCustphone(request.getParameter("custphone"));
		dao.updateCustomer(cust);
		
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
