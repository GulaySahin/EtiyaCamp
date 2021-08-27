package manager;

import entitites.Customer;
import interfaces.CustomerService;
import interfaces.UserIdentityValidatorService;

public class CustomerManager implements CustomerService {
     UserIdentityValidatorService userIdentityValidatorService;
      
     
	
	
	public CustomerManager(UserIdentityValidatorService userIdentityValidatorService  ) {
		super();
		this.userIdentityValidatorService=userIdentityValidatorService;
		
	}

	@Override
	public void add(Customer customer) {
		if(this.userIdentityValidatorService.isValid(customer)) {
			System.out.println("eklendi"+customer.getFirstName());
			
		}
		
	}

	@Override
	public void remove(Customer customer) {
		System.out.println("silindi");
		
	}

	@Override
	public void update(Customer customer) {
		System.out.println("güncellendi");
		
	}

	

}
