package interfaces;

import entitites.Customer;

public interface UserIdentityValidatorService {
	
	boolean isValid(Customer customer);

}
