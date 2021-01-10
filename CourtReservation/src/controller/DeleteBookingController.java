package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.BookingDAO;
import model.Booking;
/**
 * Servlet implementation class deleteBookingController
 */
@WebServlet("/DeleteBookingController")
public class DeleteBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingDAO dao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookingController() {
    	super();
        dao = new BookingDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")){
        int bookid= Integer.parseInt(request.getParameter("bookid"));
        dao.deleteBooking(bookid);
        
        action = "ViewBooking.jsp";
        try {
			request.setAttribute("booking", BookingDAO.getAllBooking());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
        RequestDispatcher view = request.getRequestDispatcher("ViewBooking.jsp");
        view.forward(request, response);
    }

}
