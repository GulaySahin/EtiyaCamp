package solidLsp;

public class Main {

	public static void main(String[] args) {
		//SOLID PRENSÝBÝNÝN ÜÇÜNCÜ HARFÝNÝ TEMSÝL EDEN "LISKOV'S SUBSTITUTION" ÖRNEÐÝ..
		//LISKOV'S SUBSTITUTION=NESNELERÝ BÝRBÝRÝNE BENZEDÝÐÝ BÝRBÝRÝNÝN YERÝNE KULLANMAMALISIN
		
		
		
		Customer realCustomer=new RealCustomer("Rüzgar","Azra","14415445545");
		Customer corporateCustomer= new CorporateCustomer("Zeus","654987145");
	
	
	}

}
