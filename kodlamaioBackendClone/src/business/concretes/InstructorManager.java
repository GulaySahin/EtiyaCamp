package business.concretes;

import java.util.List;

import business.abstracts.InstructorService;
import dataAccess.abstracts.InstructorDao;
import entities.concretes.Instructor;

public class InstructorManager implements InstructorService {
    InstructorDao ýnstructorDao;
	
	public InstructorManager(InstructorDao instructorDao) {
		super();
		ýnstructorDao = instructorDao;
	}

	@Override
	public void add(Instructor instructor) {
		this.ýnstructorDao.add(instructor);
		
	}

	@Override
	public void remove(Instructor instructor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Instructor> getAll() {
		// TODO Auto-generated method stub
		return this.ýnstructorDao.getAll();
	}

}
