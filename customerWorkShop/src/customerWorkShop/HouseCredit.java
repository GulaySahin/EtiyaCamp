package customerWorkShop;

public class HouseCredit extends CreditManager {
 

	@Override
	public double calculate(double price) {
		double number= price*1.10;
		System.out.println("kredi hesaplandý: "+ number);
		return price*1.10;
	}
	
    
	


}
