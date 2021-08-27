package entitites;

public class Credit {

	private int id;
	private String name;
	private double interestRate;
	
	
	public Credit() {
		super();
	}

	public Credit(int id, String name, double interestRate) {
		super();
		this.id = id;
		this.name = name;
		this.interestRate = interestRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	
}

