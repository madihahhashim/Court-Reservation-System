package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import connection.ConnectionManager;
import model.Admin;

public class AdminDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static int adminid;
	static String adname, address, ademail, adpass, adphone;
	
	//add data
    public  void addAdmin(Admin bean)
    {
        //get values

    	adname = bean.getAdname();
		address = bean.getAddress();
		ademail = bean.getAdemail();
    	adpass = bean.getAdpass();
		adphone = bean.getAdphone();
		
		
		
		System.out.println("Your cname is " + adname);
		System.out.println("status: " + address);
		System.out.println("Your id name is " + ademail);
		System.out.println("Your cname is " + adpass);
		System.out.println("phone: " + adphone);
		
		
		
        try 
        {
            //step 2: create connection
             con = ConnectionManager.getConnection();
            
            //step3 : create statement - using preparedStatement
            ps=con.prepareStatement("insert into admin(adname,address, ademail,adpass,adphone)values(?,?,?,?,?)");
            
            
            ps.setString(1,adname);
            ps.setString(2, address);
            ps.setString(3, ademail);
            ps.setString(4,adpass);
            ps.setString(5, adphone);
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
    public static List<Admin> getAllAdmin() throws ClassNotFoundException, SQLException
    {
        List<Admin> sups = new ArrayList<>();
        
        con = ConnectionManager.getConnection();
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from admin ");
        
       
        while (rs.next()) 
        {
        	 
 	        adminid=rs.getInt("adminid");
 	        adname=rs.getString("adname");
 	        address=rs.getString("address");
 	        ademail=rs.getString("ademail");
	        adpass=rs.getString("adpass");
	        adphone=rs.getString("adphone");
	        Admin ad = new Admin(adminid, adname, address,ademail, adpass, adphone);
	        sups.add(ad);

        }
       
        return sups;
    }
    
    //select a data
    public static Admin getAdminById(int adminid) {
         Admin cu = new Admin();
        
         try {
        con = ConnectionManager.getConnection();
         ps=con.prepareStatement("select * from admin where adminid=?");

         ps.setInt(1, adminid);
         ResultSet rs = ps.executeQuery();
             
         if (rs.next()) {
         cu.setAdminid(rs.getInt("adminid"));
         cu.setAdname(rs.getString("adname"));
         cu.setAddress(rs.getString("address"));
         cu.setAdemail(rs.getString("ademail"));
         cu.setAdpass(rs.getString("adpass"));
         cu.setAdphone(rs.getString("adphone"));
         
         }
         } catch (SQLException e) {
             System.out.println("failed: Cannot get the id " + e);
         }
         return cu;
        }
    
	    public static int getAdminID() {
	    	int adminid = 0;
	    	try {
	    	con = ConnectionManager.getConnection();
	    	ps = con.prepareStatement("select adminid from admin order by adminid desc limit 1");
	    	ResultSet rs = ps.executeQuery();
	    	if(rs.next()){
	    	adminid = rs.getInt("adminid");
	    	}
	    	}
	    	catch(SQLException e) {
	    	e.printStackTrace();
	    	}
	    	return adminid;
	    	}
    
  //update
    public void updateAdmin(Admin bean) {
    	adminid = bean.getAdminid();
    	adname = bean.getAdname();
		address = bean.getAddress();
		ademail = bean.getAdemail();
    	adpass = bean.getAdpass();
		adphone = bean.getAdphone();
        
        String searchQuery = "UPDATE admin SET adminid= '" + adminid + "', adname='" + adname + "',  address='" + address +"' , ademail= '" + ademail + "', adpass='" + adpass + "',  adphone='" + adphone +"' WHERE adminid= '" + adminid + "'";
        System.out.println(searchQuery);
        try {
        con = ConnectionManager.getConnection();
        stmt = con.createStatement();
        stmt.executeUpdate(searchQuery);
        } catch (SQLException e) {
            System.out.println("failed: tak boleh update data " + e);
        }
        }
    
    public void deleteAdmin(int adminid) {
        try {
        con = ConnectionManager.getConnection();
        ps=con.prepareStatement("delete from customer where adminid=?");
        ps.setInt(1, adminid);
        ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("failed: tak boleh delete data customer " + e);
        }
       }
 }               


