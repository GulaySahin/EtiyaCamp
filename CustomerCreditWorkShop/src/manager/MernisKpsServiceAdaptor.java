package manager;

import customerWorkShop.MernisKpsService;
import entitites.Customer;
import interfaces.UserIdentityValidatorService;

public class MernisKpsServiceAdaptor implements UserIdentityValidatorService {

	 
	@Override
	public boolean isValid(Customer customer) {
	MernisKpsService mernisKpsService=new MernisKpsService();
	
	return mernisKpsService.tcKimlikDogrula(Long.parseLong(customer.getNationalIdentityNumber()),customer.getFirstName(),customer.getLastName(), customer.getDateOfYear());
	}
	

}
