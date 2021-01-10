package model;

public class Futsal extends Courts{
	 private boolean ball;
	 final double ballPrice = 5.00; 
	 final double perHour = 7.00;
	

	public Futsal(String cid, String cname, String status, boolean ball) {
		super(cid, cname, status);
		this.ball = ball;
	}

	public Futsal() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Futsal(String cid, String cname, String status) {
		super(cid, cname, status);
		// TODO Auto-generated constructor stub
	}

	public boolean getBall() {
		return ball;
	}

	public void setBall(boolean ball) {
		this.ball = ball;
	}


	public double computePayment(boolean ball, int hours)
	{
		double payment = 0.0;
		if(ball == true)
		{
			payment = ballPrice + (hours * perHour);
		}
		else
		{
			payment = (hours * perHour);
		}
		return payment;
	}
}
	
	
	 

