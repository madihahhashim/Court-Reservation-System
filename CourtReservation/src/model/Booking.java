package model;

import java.util.Date;

public class Booking {
	private int bookid;
	private int custid;
	private int adminid;
	private String cid;
	private String booktime;
	private Date bookdate;
	private double totalprice;
	private int hours;
	
	public Booking(int bookid, int custid, int adminid, String cid, String booktime, Date bookdate, double totalprice, int hours) {
		
		this.bookid = bookid;
		this.custid = custid;
		this.adminid = adminid;
		this.cid = cid;
		this.booktime = booktime;
		this.bookdate = bookdate;
		this.totalprice = totalprice;
		this.hours = hours;
	}

	public Booking() {
		
		// TODO Auto-generated constructor stub
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getBooktime() {
		return booktime;
	}

	public void setBooktime(String booktime) {
		this.booktime = booktime;
	}

	public Date getBookdate() {
		return bookdate;
	}

	public void setBookdate(Date bookdate) {
		this.bookdate = bookdate;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	

}
