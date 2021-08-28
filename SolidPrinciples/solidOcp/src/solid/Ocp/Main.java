package solid.Ocp;

public class Main {

	public static void main(String[] args) {
		//SOLID PRENSÝBÝNÝN ÝKÝNCÝ HARFÝNÝ TEMSÝL EDEN "OPEN CLOSED" ÖRNEÐÝ..
		//OPEN CLOSED=PROGRAMLAR YENÝ ÖZELLÝK EKLEMEYE AÇIK,FAKAT O ÖZELLÝKLERÝ DEÐÝÞTÝRMEYE KAPALI OLMALIDIR.YANÝ MEVCUTTAKÝ KODLAR DEÐÝÞTÝRÝLMEMELÝDÝR.
		
	CustomerManager customerManager=new CustomerManager(new EfCustomerDal());
		customerManager.add();

	}

}
