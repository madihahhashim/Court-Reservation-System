package model;

public class Badminton extends Courts{
	private boolean racket;
	private boolean shuttle;
	final double racketPrice = 5.00; 
	final double shuttlePrice = 1.00; 
	final double perHour = 7.00;
	
	
	
	

	public Badminton(String cid, String cname, String status, boolean racket, boolean shuttle) {
		super(cid, cname, status);
		this.racket = racket;
		this.shuttle = shuttle;
	}


	public Badminton() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Badminton(String cid, String cname, String status) {
		super(cid, cname, status);
		// TODO Auto-generated constructor stub
	}


	public boolean getRacket() {
		return racket;
	}
	public void setRacket(boolean racket) {
		this.racket = racket;
	}
	public boolean getShuttle() {
		return shuttle;
	}
	public void setShuttle(boolean shuttle) {
		this.shuttle = shuttle;
	}
	
	public double computePayment(boolean racket, boolean shuttle, int hours)
	{
		double payment = 0.0;
		if(racket == true && shuttle == true)
		{
			payment = racketPrice + shuttlePrice +(hours * perHour);
		}
		else if(racket == true && shuttle != true)
		{
			payment = racketPrice + (hours * perHour);
		}
		else if(racket != true && shuttle == true)
		{
			payment = shuttlePrice + (hours * perHour);
		}
		else
		{
			payment = (hours * perHour);
		}
		return payment;
	}
	
	
	
	
	
}
