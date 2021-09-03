package business.abstracts;

import java.util.List;

import entities.concretes.Category;

public interface CategoryService {
	
	void add(Category category);
	
	void update(Category category);
	
	void remove(Category category);
	
	List<Category>getAll();

}
