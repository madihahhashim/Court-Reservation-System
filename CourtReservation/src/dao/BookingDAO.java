package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.ConnectionManager;
import model.Booking;
//import model.Customer;
//import model.Service;


public class BookingDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static int bookid, adminid, custid, hours;
	static double totalprice;
	static Date bookdate; 
	static String booktime, cid;
	
	//add data
    public  void addBooking(Booking bean)
    {
        //get values
    	custid = bean.getCustid();
		adminid = bean.getAdminid();
		cid = bean.getCid();
    	bookdate = bean.getBookdate();
		booktime = bean.getBooktime();
		totalprice = bean.getTotalprice();
		hours = bean.getHours();
		
		
		System.out.println("Your date name is " + bookdate);
		System.out.println("Your time is " + booktime);
		System.out.println("total: " + totalprice);
		System.out.println("Your hours is " + hours);
		System.out.println("Your custID is " + custid);
		System.out.println("admin: " + adminid);
		System.out.println("Your court is " + cid);
		
        try 
        {
            //step 2: create connection
             con = ConnectionManager.getConnection();
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
             String bdate = dateFormat.format(bookdate);
             
            
            //step3 : create statement - using preparedStatement
            ps=con.prepareStatement("insert into booking(bookdate,booktime,totalprice,hours,custid,adminid,cid)values(?,?,?,?,?,?,?)");
            
            ps.setDate(1, java.sql.Date.valueOf(bdate));
            ps.setString(2,booktime);
            ps.setDouble(3, totalprice);
            ps.setInt(4,hours);
            ps.setInt(5,custid);
            ps.setInt(6, adminid);
            ps.setString(7, cid);
            System.out.print(ps);
            //step 4: execute statement
            ps.executeUpdate();
            //step 5: close connection
            con.close();
        }
        catch (Exception ex) 
        {
            System.out.println("failed: An Exception has occurred! " + ex);
        }
    }
    

    
    //list data
    public static List<Booking> getAllBooking() throws ClassNotFoundException, SQLException
    {
        List<Booking> sups = new ArrayList<>();
        
        con = ConnectionManager.getConnection();
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from booking ");
        
       
        while (rs.next()) 
        {
        	 
 	        bookid=rs.getInt("bookid");
 	        bookdate=rs.getDate("bookdate");
 	        booktime=rs.getString("booktime");
 	        totalprice=rs.getDouble("totalprice");
 	        hours=rs.getInt("hours");
 	        custid=rs.getInt("custid");
 	        adminid=rs.getInt("adminid");
 	        cid=rs.getString("cid");
        
       
	        Booking bo = new Booking(bookid, custid, adminid, cid, booktime, bookdate, totalprice, hours);
	        sups.add(bo);
	      
        
        }
       
        return sups;
}
    
  //select a data
    public static Booking getBookingById(int bookid) {
         Booking sup = new Booking();
        
         try {
        con = ConnectionManager.getConnection();
         ps=con.prepareStatement("select * from booking where bookid=?");

         ps.setInt(1, bookid);
         ResultSet rs = ps.executeQuery();
             
         if (rs.next()) {
         sup.setBookid(rs.getInt("bookid"));
         sup.setBookdate(rs.getDate("bookdate"));
         sup.setBooktime(rs.getString("booktime"));
         sup.setTotalprice(rs.getDouble("totalprice"));
         sup.setHours(rs.getInt("hours"));
         sup.setCustid(rs.getInt("custid"));
         sup.setAdminid(rs.getInt("adminid"));
         sup.setCid(rs.getString("cid"));
         }
         } catch (SQLException e) {
             System.out.println("failed: Cannot get the id " + e);
         }
         return sup;
        }
    
	    public static int getBookingId() {
	    	int bookid = 0;
	    	try {
	    	con = ConnectionManager.getConnection();
	    	ps = con.prepareStatement("select bookid from booking order by bookid desc limit 1");
	    	ResultSet rs = ps.executeQuery();
	    	if(rs.next()){
	    	bookid = rs.getInt("bookid");
	    	}
	    	}
	    	catch(SQLException e) {
	    	e.printStackTrace();
	    	}
	    	return bookid;
	    	}
    
  //update
    public void updateBooking(Booking bean) {
    	bookid = bean.getBookid();
    	custid = bean.getCustid();
		adminid = bean.getAdminid();
		cid = bean.getCid();
    	bookdate = bean.getBookdate();
		booktime = bean.getBooktime();
		totalprice = bean.getTotalprice();
		hours = bean.getHours();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String bdate = dateFormat.format(bookdate);
        
        String searchQuery = "UPDATE booking SET bookdate= '" + java.sql.Date.valueOf(bdate) + "', booktime='" + booktime + "',  totalprice='" + totalprice +"', custid='" + custid + "',adminid='" + adminid +"' ,cid='" + cid + "' ,hours='" + hours + "' WHERE bookid= '" + bookid + "'";
        System.out.println(searchQuery);
        try {
        con = ConnectionManager.getConnection();
        stmt = con.createStatement();
        stmt.executeUpdate(searchQuery);
        } catch (SQLException e) {
            System.out.println("failed: tak boleh update data " + e);
        }
        }
    
    public void deleteBooking(int bookid) {
        try {
        con = ConnectionManager.getConnection();
        ps=con.prepareStatement("delete from booking where bookid=?");
        ps.setInt(1, bookid);
        ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("failed: tak boleh delete data customer " + e);
        }
       }
 }               
