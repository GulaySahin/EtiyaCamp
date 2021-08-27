package customerWorkShop;

import entitites.Customer;

public class Main {

	public static void main(String[] args) {
		Customer customer1=new Customer();
		customer1.setId(1);
		customer1.setFirstName("gülay");
		customer1.setLastName("sahin");
		customer1.setNationalIdentityNumber("5465154");
		customer1.setDateOfYear(1245);
		
		CustomerManager customerManager=new CustomerManager(new MernisKpsServiceAdaptor());
       customerManager.add(customer1);
        
       CreditManager creditManager=new HouseCredit();
      // BaseService baseService=new CreditManager(new HouseCredit(null));
       creditManager.calculate(200);
       CreditManager creditManage1=new CarCredit();
       creditManage1.calculate(652);
       
       
	}

}
