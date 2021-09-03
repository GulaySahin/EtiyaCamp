package business.concretes;

import java.util.List;

import business.abstracts.CourseService;
import dataAccess.abstracts.CourseDao;
import entities.concretes.Course;

public class CourseManager implements CourseService {

	CourseDao courseDao;
	
	public CourseManager(CourseDao courseDao) {
		super();
		this.courseDao = courseDao;
	}

	@Override
	public void add(Course course) {
		this.courseDao.add(course);
		
	}

	@Override
	public void update(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Course> getAll() {
		
		return this.courseDao.getAll();
	}
	

}
