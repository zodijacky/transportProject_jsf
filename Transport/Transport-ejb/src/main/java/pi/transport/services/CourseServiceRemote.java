package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Course;
import pi.transport.persistance.Driver;
import pi.transport.persistance.User;


@Remote
public interface CourseServiceRemote {

	public void create(Course course);
	 public Course find(Integer id);
	 public void update(Course course);
	 public void delete(Course course);
	 public void delete(Integer id);
	 public List<Course> findAll();
	 public List<Course> findByDriver(Driver driver);
	 public List<Course>  FindCourseByCost(Double cost);
	// public Course  FindCourseByNbPassangers(double cost);
	
}
