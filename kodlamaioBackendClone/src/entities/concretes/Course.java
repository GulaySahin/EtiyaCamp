package entities.concretes;

public class Course {
	
	private int id;
	
	private String name;
	
	private Student student;
	
	private String description;
	
	private String imgPath;

	public Course() {
		super();
	}

	public Course(int id, String name, Student student, String description, String imgPath) {
		super();
		this.id = id;
		this.name = name;
		this.student = student;
		this.description = description;
		this.imgPath = imgPath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	

}
