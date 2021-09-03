package kodlamaioUserInterface;

import java.util.List;

import business.abstracts.CategoryService;
import business.abstracts.CourseService;
import business.abstracts.InstructorService;
import business.abstracts.StudentService;
import business.concretes.CategoryManager;
import business.concretes.CourseManager;
import business.concretes.InstructorManager;
import business.concretes.StudentManager;
import dataAccess.abstracts.CategoryDao;
import dataAccess.abstracts.StudentDao;
import dataAccess.concretes.hibernate.HibernateCategoryDao;
import dataAccess.concretes.hibernate.HibernateCourseDao;
import dataAccess.concretes.hibernate.HibernateInstructorDao;
import entities.concretes.Category;
import entities.concretes.Course;
import entities.concretes.Instructor;
import entities.concretes.Student;

public class Main {

	public static void main(String[] args) {
		
	Student student=new Student(1,"gülay","þahin","gulay_431@hotmail.com","12345","resim.jpg");
	
	// StudentService studentService=new StudentManager(null)
			
			
   Course course=new Course(1,"java", student, "hxcbasb", "asdf");
   CourseService courseService=new CourseManager(new HibernateCourseDao());
   courseService.add(course);
  
   
   Instructor instructor=new Instructor();
   instructor.setId(1);
   instructor.setName("Engin");
   instructor.setLastName("demiroð");
   instructor.setCourse(course);
   instructor.setDescription("dchksjhfk");
   
   InstructorService instructorService = new InstructorManager(new HibernateInstructorDao());
	instructorService.add(instructor);
	
	for (Instructor instructorItem : instructorService.getAll()) {
		System.out.println("Eðitmenler: " + instructorItem.getName());
	}

  

   Category category=new Category(1, "yazýlým","10 saat");
   
   CategoryService categoryService=new CategoryManager(new HibernateCategoryDao());
   categoryService.add(category);
   
   for (Category categoryItem : categoryService.getAll()) {
		System.out.println("Kategoriler: " + categoryItem.getName());
	}
	}

}
