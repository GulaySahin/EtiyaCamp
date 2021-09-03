package dataAccess.concretes.hibernate;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.InstructorDao;
import entities.concretes.Instructor;

public class HibernateInstructorDao implements InstructorDao{

	
	List<Instructor> instructors;

	public HibernateInstructorDao() {
		this.instructors = new ArrayList<Instructor>();
	}

	@Override
	public void add(Instructor entity) {
		this.instructors.add(entity);
		
	}

	@Override
	public void remove(Instructor entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Instructor entitiy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Instructor> getAll() {
		// TODO Auto-generated method stub
		return this.instructors;
	}

}
