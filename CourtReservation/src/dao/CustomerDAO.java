package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import connection.ConnectionManager;
import model.Customer;

public class CustomerDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static int custid;
	static String custname, custaddress, custemail, custpass, custphone;
	
	//add data
    public  void addCustomer(Customer bean)
    {
        //get values

    	custname = bean.getCustname();
		custaddress = bean.getCustaddress();
		custemail = bean.getCustemail();
    	custpass = bean.getCustpass();
		custphone = bean.getCustphone();
		
		
		
		System.out.println("Your cname is " + custname);
		System.out.println("status: " + custaddress);
		System.out.println("Your id name is " + custemail);
		System.out.println("Your cname is " + custpass);
		System.out.println("status: " + custphone);
		
		
		
        try 
        {
            //step 2: create connection
             con = ConnectionManager.getConnection();
            
            //step3 : create statement - using preparedStatement
            ps=con.prepareStatement("insert into customer(custname,custaddress, custemail,custpass,custphone)values(?,?,?,?,?)");
            
            
            ps.setString(1,custname);
            ps.setString(2, custaddress);
            ps.setString(3, custemail);
            ps.setString(4,custpass);
            ps.setString(5, custphone);
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
    public static List<Customer> getAllCustomer() throws ClassNotFoundException, SQLException
    {
        List<Customer> sups = new ArrayList<>();
        
        con = ConnectionManager.getConnection();
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from customer ");
        
       
        while (rs.next()) 
        {
        	 
 	        custid=rs.getInt("custid");
 	        custname=rs.getString("custname");
 	        custaddress=rs.getString("custaddress");
 	        custemail=rs.getString("custemail");
	        custpass=rs.getString("custpass");
	        custphone=rs.getString("custphone");
	        Customer cust = new Customer(custid, custname, custaddress,custemail, custpass, custphone);
	        sups.add(cust);

        }
       
        return sups;
    }
    
    //select a data
    public static Customer getCustomerById(int custid) {
         Customer cu = new Customer();
        
         try {
        con = ConnectionManager.getConnection();
         ps=con.prepareStatement("select * from customer where custid=?");

         ps.setInt(1, custid);
         ResultSet rs = ps.executeQuery();
             
         if (rs.next()) {
         cu.setCustid(rs.getInt("custid"));
         cu.setCustname(rs.getString("custname"));
         cu.setCustaddress(rs.getString("custaddress"));
         cu.setCustemail(rs.getString("custemail"));
         cu.setCustpass(rs.getString("custpass"));
         cu.setCustphone(rs.getString("custphone"));
         
         }
         } catch (SQLException e) {
             System.out.println("failed: Cannot get the id " + e);
         }
         return cu;
        }
    
	    public static int getCustomerID() {
	    	int custid = 0;
	    	try {
	    	con = ConnectionManager.getConnection();
	    	ps = con.prepareStatement("select custid from customer order by custid desc limit 1");
	    	ResultSet rs = ps.executeQuery();
	    	if(rs.next()){
	    	custid = rs.getInt("cid");
	    	}
	    	}
	    	catch(SQLException e) {
	    	e.printStackTrace();
	    	}
	    	return custid;
	    	}
    
  //update
    public void updateCustomer(Customer bean) {
    	custid = bean.getCustid();
    	custname = bean.getCustname();
		custaddress = bean.getCustaddress();
		custemail = bean.getCustemail();
    	custpass = bean.getCustpass();
		custphone = bean.getCustphone();
        
        String searchQuery = "UPDATE customer SET custid= '" + custid + "', custname='" + custname + "',  custaddress='" + custaddress +"' , custemail= '" + custemail + "', custpass='" + custpass + "',  custphone='" + custphone +"' WHERE custid= '" + custid + "'";
        System.out.println(searchQuery);
        try {
        con = ConnectionManager.getConnection();
        stmt = con.createStatement();
        stmt.executeUpdate(searchQuery);
        } catch (SQLException e) {
            System.out.println("failed: tak boleh update data " + e);
        }
        }
    
    public void deleteCustomer(int custid) {
        try {
        con = ConnectionManager.getConnection();
        ps=con.prepareStatement("delete from customer where custid=?");
        ps.setInt(1, custid);
        ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("failed: tak boleh delete data customer " + e);
        }
       }
 }               


