package pi.transport.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.transport.persistance.Request;
import pi.transport.persistance.Student;
import pi.transport.persistance.Subscription;

/**
 * Session Bean implementation class StudentService
 */
@Stateless
@LocalBean
public class StudentService implements StudentServiceRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Student create(Student student) {
		em.persist(student);
		
		return student;		
	}

	@Override
	public Student find(Integer cin) {
		return em.find(Student.class, cin);
	}

	@Override
	public void update(Student student) {
		em.merge(student);
		
	}

	@Override
	public void delete(Student student) {
		em.remove(em.merge(student));
		
	}

	@Override
	public void delete(Integer cin) {
		
		try {
			Student student = em.find(Student.class, cin);
			em.remove(student);
		} catch (Exception e) {
			
		}
		
		
	}
	
    /**
     * Default constructor. 
     */
    public StudentService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Student> findAll() {
		
		return em.createQuery("select s from Student s", Student.class)
				.getResultList();
	}

	@Override
	public Student findByLoginPassword(String login, String password) {
		
		Student student = em.createQuery("SELECT s FROM Student s WHERE s.login = '" + login + "' AND s.passWord = '" + password + "'", Student.class)
		.getSingleResult();
		
		return student;
	}
   
}
