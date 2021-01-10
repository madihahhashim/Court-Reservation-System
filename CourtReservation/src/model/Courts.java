package model;

public class Courts {
	private String cid;
	private String cname;
	private String status;
	
	
	public Courts(String cid, String cname, String status) {
		
		this.cid = cid;
		this.cname = cname;
		this.status = status;
	}
		

	public Courts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	

}
