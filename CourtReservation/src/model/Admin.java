package model;

public class Admin {
	private int adminid;
	private String adname;
	private String address;
	private String ademail;
	private String adpass;
	private String adphone;
	
	public Admin(int adminid, String adname, String address, String ademail, String adpass, String adphone) {
		super();
		this.adminid = adminid;
		this.adname = adname;
		this.address = address;
		this.ademail = ademail;
		this.adpass = adpass;
		this.adphone = adphone;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdname() {
		return adname;
	}

	public void setAdname(String adname) {
		this.adname = adname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdemail() {
		return ademail;
	}

	public void setAdemail(String ademail) {
		this.ademail = ademail;
	}

	public String getAdpass() {
		return adpass;
	}

	public void setAdpass(String adpass) {
		this.adpass = adpass;
	}

	public String getAdphone() {
		return adphone;
	}

	public void setAdphone(String adphone) {
		this.adphone = adphone;
	}
	
	

}
