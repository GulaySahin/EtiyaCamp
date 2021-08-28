package solidLsp;

public class CorporateCustomer extends Customer {
	private String taxNumber;
	private String title;
	
	public CorporateCustomer() {
		super();
	}

	
	public CorporateCustomer(String taxNumber, String title) {
		super();
		this.taxNumber = taxNumber;
		this.title = title;
	}


	public String getTaxNumber() {
		return taxNumber;
	}


	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
}
