package customerWorkShop;

import entitites.Customer;

public class MernisKpsServiceAdaptor implements UserIdentityValidatorService {

	 
	@Override
	public boolean isValid(Customer customer) {
	MernisKpsService mernisKpsService=new MernisKpsService();
	
	return mernisKpsService.tcKimlikDogrula(Long.parseLong(customer.getNationalIdentityNumber()),customer.getFirstName(),customer.getLastName(), customer.getDateOfYear());
	}
	

}
