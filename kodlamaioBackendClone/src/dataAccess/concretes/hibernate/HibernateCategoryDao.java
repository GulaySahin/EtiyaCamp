package dataAccess.concretes.hibernate;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.CategoryDao;
import entities.concretes.Category;
import entities.concretes.Student;

public class HibernateCategoryDao implements CategoryDao {
	
	List<Category>categories;

	public HibernateCategoryDao() {
		super();
		this.categories = new ArrayList<Category>();
	}

	@Override
	public void add(Category entity) {
		this.categories.add(entity);
		
	}

	@Override
	public void remove(Category entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category entitiy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return this.categories;
	}

}
