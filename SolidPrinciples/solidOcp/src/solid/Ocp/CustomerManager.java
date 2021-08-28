package solid.Ocp;

public class CustomerManager  implements CustomerDalService {
	
	private CustomerDalService customerDalService;
	
	
   
	public CustomerManager(CustomerDalService customerDalService) {
		super();
		this.customerDalService=customerDalService;
	}

	public void add() {
		
		customerDalService.add();
	}
	
	
}
