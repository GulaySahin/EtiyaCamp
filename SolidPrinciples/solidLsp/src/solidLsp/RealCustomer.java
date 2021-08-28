package solidLsp;

public class RealCustomer extends Customer  {
	private String firstName;
	private String lastName;
	private String nationalIdentityNumber;
	
	public RealCustomer() {
		// TODO Auto-generated constructor stub
		super();
	}

	public RealCustomer(String firstName, String lastName, String nationalIdentityNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalIdentityNumber = nationalIdentityNumber;
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
	

}
