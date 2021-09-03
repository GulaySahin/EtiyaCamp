package business.abstracts;

import java.util.List;

import entities.concretes.Student;

public interface StudentService {
	
	void add(Student student);
	
	void remove(Student student);
	
	void update(Student student);
	
	List<Student> getAll();

}
