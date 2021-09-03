package dataAccess.abstracts;

import java.util.List;

public interface EntityRepository <T> {
	
	void add(T entity);
	
	void remove(T entity);
	
	void update(T entitiy);
	
	List<T>getAll();
	
	
	

}
