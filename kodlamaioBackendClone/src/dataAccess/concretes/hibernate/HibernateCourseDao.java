package dataAccess.concretes.hibernate;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.CourseDao;
import entities.concretes.Course;
import entities.concretes.Student;

public class HibernateCourseDao implements CourseDao {
	
	List<Course>courses;

	public HibernateCourseDao() {
		super();
		this.courses = new ArrayList<Course>();
	}

	@Override
	public void add(Course entity) {
		this.courses.add(entity);
		
	}

	@Override
	public void remove(Course entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Course entitiy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return this.courses;
	}

}
