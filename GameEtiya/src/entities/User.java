package entities;

public class User {
	private int id;
	private String name;
	private String lastName;
	private int ageofYear;
	private String identityNumber;
	public User() {
		super();
	}
	public User(int id, String name, String lastName, int ageofYear, String identityNumber) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.ageofYear = ageofYear;
		this.identityNumber = identityNumber;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAgeofYear() {
		return ageofYear;
	}
	public void setAgeofYear(int ageofYear) {
		this.ageofYear = ageofYear;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	

}
