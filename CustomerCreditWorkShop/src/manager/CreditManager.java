package manager;

import interfaces.BaseCreditService;

public class CreditManager implements BaseCreditService {

	
	@Override
	public double calculate(double price) {
		
		return price*1.20;
	}
	
	
	
}