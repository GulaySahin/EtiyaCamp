package entities.concretes;

public class Instructor {
	
	private int id;
	private String name;
	private String lastName;
	private Course course;
	private String description;
	public Instructor() {
		super();
	}
	public Instructor(int id, String name, String lastName, Course course, String description) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.course = course;
		this.description = description;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
