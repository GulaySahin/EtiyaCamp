package business.abstracts;

import java.util.List;

import entities.concretes.Instructor;

public interface InstructorService {
	
	void add(Instructor żnstructor);
	
	void remove(Instructor żnstructor);
	
	List<Instructor>getAll();
	

}
