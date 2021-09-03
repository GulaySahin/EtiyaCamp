package business.abstracts;

import java.util.List;

import entities.concretes.Instructor;

public interface InstructorService {
	
	void add(Instructor ýnstructor);
	
	void remove(Instructor ýnstructor);
	
	List<Instructor>getAll();
	

}
