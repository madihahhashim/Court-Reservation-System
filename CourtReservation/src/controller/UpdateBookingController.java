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
 * Servlet implementation class updateBookingController
 */
@WebServlet("/UpdateBookingController")
public class UpdateBookingController extends HttpServlet {
	
	private BookingDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookingController() {
    	dao = new BookingDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookid = Integer.parseInt(request.getParameter("bookid"));
        Booking book = dao.getBookingById(bookid); 
        request.setAttribute("booking", book);
        RequestDispatcher view = request.getRequestDispatcher("UpdateBooking.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Booking book = new Booking();
		book.setBookid(Integer.parseInt(request.getParameter("bookid")));
		book.setCustid(Integer.parseInt(request.getParameter("custid")));
		book.setCid(request.getParameter("cid"));
		String date = request.getParameter("bookdate");
		Date newDate;
		try {
		newDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
		book.setBookdate(newDate);
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		book.setBooktime(request.getParameter("booktime"));

		book.setHours(Integer.parseInt(request.getParameter("hours")));
		book.setTotalprice(Double.parseDouble(request.getParameter("totalprice")));
		book.setAdminid(Integer.parseInt(request.getParameter("adminid")));
		dao.updateBooking(book);
		
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
