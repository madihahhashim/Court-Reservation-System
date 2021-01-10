package model;

public class Customer {
	private int custid;
	private String custname;
	private String custaddress;
	private String custemail;
	private String custpass;
	private String custphone;
	
	public Customer(int custid, String custname, String custaddress, String custemail, String custpass, String custphone) {
		
		this.custid = custid;
		this.custname = custname;
		this.custaddress = custaddress;
		this.custemail = custemail;
		this.custpass = custpass;
		this.custphone = custphone;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCustaddress() {
		return custaddress;
	}

	public void setCustaddress(String custaddress) {
		this.custaddress = custaddress;
	}

	public String getCustemail() {
		return custemail;
	}

	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}

	public String getCustpass() {
		return custpass;
	}

	public void setCustpass(String custpass) {
		this.custpass = custpass;
	}

	public String getCustphone() {
		return custphone;
	}

	public void setCustphone(String custphone) {
		this.custphone = custphone;
	}
	
	
	
	

}
