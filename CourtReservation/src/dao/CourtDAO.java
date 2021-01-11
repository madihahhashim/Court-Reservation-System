package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;

import connection.ConnectionManager;

import model.Courts;

public class CourtDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String cid, cname, status;
	
	//add data
    public  void addCourt(Courts bean)
    {
        //get values
		cid = bean.getCid();
    	cname = bean.getCname();
		status = bean.getStatus();
		
		
		
		System.out.println("Your id name is " + cid);
		System.out.println("Your cname is " + cname);
		System.out.println("status: " + status);
		
		
        try 
        {
            //step 2: create connection
             con = ConnectionManager.getConnection();
            
            //step3 : create statement - using preparedStatement
            ps=con.prepareStatement("insert into courts(cid,cname,status)values(?,?,?)");
            
            ps.setString(1, cid);
            ps.setString(2,cname);
            ps.setString(3, status);
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
    public static List<Courts> getAllCourts() throws ClassNotFoundException, SQLException
    {
        List<Courts> sups = new ArrayList<>();
        
        con = ConnectionManager.getConnection();
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from courts ");
        
       
        while (rs.next()) 
        {
        	 
 	        cid=rs.getString("cid");
 	        cname=rs.getString("cname");
 	        status=rs.getString("status");

	        Courts co = new Courts(cid, cname, status);
	        sups.add(co);

        }
       
        return sups;
    }
    
    //select a data
    public static Courts getCourtsById(String cid) {
         Courts sup = new Courts();
        
         try {
        con = ConnectionManager.getConnection();
         ps=con.prepareStatement("select * from courts where cid=?");

         ps.setString(1, cid);
         ResultSet rs = ps.executeQuery();
             
         if (rs.next()) {
         sup.setCid(rs.getString("cid"));
         sup.setCname(rs.getString("cname"));
         sup.setStatus(rs.getString("status"));
         
         }
         } catch (SQLException e) {
             System.out.println("failed: Cannot get the id " + e);
         }
         return sup;
        }
    
	    public static int getCourtID() {
	    	int cid = 0;
	    	try {
	    	con = ConnectionManager.getConnection();
	    	ps = con.prepareStatement("select cid from courts order by cid desc limit 1");
	    	ResultSet rs = ps.executeQuery();
	    	if(rs.next()){
	    	cid = rs.getInt("cid");
	    	}
	    	}
	    	catch(SQLException e) {
	    	e.printStackTrace();
	    	}
	    	return cid;
	    	}
    
  //update
    public void updateCourts(Courts bean) {
    	cid = bean.getCid();
    	cname = bean.getCname();
		status = bean.getStatus();
        
        String searchQuery = "UPDATE courts SET cid= '" + cid + "', cname='" + cname + "',  status='" + status +"' WHERE cid= '" + cid + "'";
        System.out.println(searchQuery);
        try {
        con = ConnectionManager.getConnection();
        stmt = con.createStatement();
        stmt.executeUpdate(searchQuery);
        } catch (SQLException e) {
            System.out.println("failed: tak boleh update data " + e);
        }
        }
    
    public void deleteCourts(String cid) {
        try {
        con = ConnectionManager.getConnection();
        ps=con.prepareStatement("delete from courts where cid=?");
        ps.setString(1, cid);
        ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("failed: tak boleh delete data customer " + e);
        }
       }
 }               


