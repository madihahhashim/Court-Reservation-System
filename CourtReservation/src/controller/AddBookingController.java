package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookingDAO;
import model.Booking;

/**
 * Servlet implementation class addBookingController
 */
@WebServlet("/AddBookingController")
public class AddBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingDAO dao;
	
	public AddBookingController()
	{
		super();
		dao = new BookingDAO();
	}
	

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			Booking book = new Booking();
			
			book.setCustid(Integer.parseInt(request.getParameter("custid")));
			book.setAdminid(Integer.parseInt(request.getParameter("adminid")));
			book.setCid(request.getParameter("cid"));
			book.setBooktime(request.getParameter("booktime"));
			String date = request.getParameter("bookdate");
			Date newDate;
			try {
			newDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
			book.setBookdate(newDate);
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			book.setTotalprice(Double.parseDouble(request.getParameter("totalprice")));
			
			dao.addBooking(book);
			
			try {
				request.setAttribute("booking", BookingDAO.getAllBooking());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewBooking.jsp");
			dispatcher.forward(request, response);
		
	}

}

