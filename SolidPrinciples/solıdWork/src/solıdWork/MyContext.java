package solýdWork;

public class MyContext implements ServiceManager {

	@Override
	public void update() {
		System.out.println("güncelendi");
		
	}

	@Override
	public void insert() {
		System.out.println("eklendi");
		
	}

}
