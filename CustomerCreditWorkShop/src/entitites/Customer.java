package entitites;

public class Customer {
private int id;
private String firstName;
private String lastName;
private String nationalIdentityNumber;
private int dateOfYear;
public Customer() {
	super();
}
public Customer(int id, String firstName, String lastName, String nationalIdentityNumber, int dateOfYear) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.nationalIdentityNumber = nationalIdentityNumber;
	this.dateOfYear = dateOfYear;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getNationalIdentityNumber() {
	return nationalIdentityNumber;
}
public void setNationalIdentityNumber(String nationalIdentityNumber) {
	this.nationalIdentityNumber = nationalIdentityNumber;
}
public int getDateOfYear() {
	return dateOfYear;
}
public void setDateOfYear(int dateOfYear) {
	this.dateOfYear = dateOfYear;
}
}
