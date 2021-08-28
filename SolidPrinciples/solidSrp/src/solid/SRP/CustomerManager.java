package solid.SRP;

public class CustomerManager {
   
	public void TransactionalOperation () {
	
	insert();
	update();
	}
	
	public void insert() {
		MyContext myContext=new MyContext();
		myContext.insert();
	}
	
	public void update() {
		MyContext myContext=new MyContext();
		myContext.update();
	}
}
