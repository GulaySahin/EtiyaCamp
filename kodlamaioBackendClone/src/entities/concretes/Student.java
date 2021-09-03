package entities.concretes;

public class Student extends User {
	private String imgPath;

	public Student() {
		super();
	}

	public Student(int id, String firstName, String lastName, String eMail, String password, String imgPath) {
		super(id, firstName,lastName, eMail, password);
		this.imgPath = imgPath;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	

}
