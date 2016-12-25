package pi.transport.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import javax.persistence.TypedQuery;

import pi.transport.persistance.Course;
import pi.transport.persistance.Driver;
import pi.transport.persistance.User;


/**
 * Session Bean implementation class CourseService
 */
@Stateless
@LocalBean
public class CourseService implements CourseServiceRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    
	public CourseService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void create(Course course) {
		em.persist(course);
	}

	@Override
	public Course find(Integer id) {
		return em.find(Course.class, id);
	}

	@Override
	public void update(Course course) {
		em.merge(course);
	}

	@Override
	public void delete(Course course) {
		em.remove(em.merge(course));
		
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.find(Course.class, id));
		
	}

	@Override
	public List<Course> findAll() {
		
		return em
				.createQuery("select c from Course c", Course.class)
				.getResultList();
	}

	@Override
	public List<Course> findByDriver(Driver driver) {
		return em
				.createQuery("select c from Course c where c.driver=:x", Course.class)
				.setParameter("x",driver)
				.getResultList();
	}
	@Override
	 public List<Course> FindCourseByCost(Double cost) {
		
		
		return em
				.createQuery("Select c from Course c where c.cost=:x", Course.class)
				.setParameter("x",cost)
				.getResultList();
} 

}
