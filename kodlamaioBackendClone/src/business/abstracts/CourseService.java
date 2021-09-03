package business.abstracts;

import java.util.List;

import entities.concretes.Course;

public interface CourseService {
	
	void add(Course course);
	
	void update(Course course);
	
	void remove(Course course);
	 

	
	List<Course>getAll();

}
