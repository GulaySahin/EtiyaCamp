package dataAccess.concretes.hibernate;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.StudentDao;
import entities.concretes.Student;

public class HibernateStudentDao implements StudentDao {

	List<Student>students;
	
	public HibernateStudentDao() {
		super();
		this.students =new ArrayList<Student>();
	}

	@Override
	public void add(Student entity) {
		this.students.add(entity);
		
	}

	@Override
	public void remove(Student entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Student entitiy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return this.students;
	}


}
