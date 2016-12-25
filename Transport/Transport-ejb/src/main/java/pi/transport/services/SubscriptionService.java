package pi.transport.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.transport.persistance.Student;
import pi.transport.persistance.Subscription;

/**
 * Session Bean implementation class SubscriptionService
 */
@Stateless
@LocalBean
public class SubscriptionService implements SubscriptionServiceRemote {


	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Subscription create(Subscription subscription) {
		em.persist(subscription);
		
		return subscription;
	}

	@Override
	public Subscription find(Integer id) {
		
		return em.find(Subscription.class, id);
	}

	@Override
	public void update(Subscription subscription) {
		
		em.merge(subscription);
		
	}

	@Override
	public void delete(Subscription subscription) {
		
		em.remove(em.merge(subscription));
		
	}

	@Override
	public void delete(Integer id) {
		
		try {
			Subscription subscription = em.find(Subscription.class, id);
			em.remove(subscription);
			
		} catch (Exception e) {
			
		}
		
	}
	
    /**
     * Default constructor. 
     */
    public SubscriptionService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Subscription> findAll() {
		
		return em.createQuery("select s from Subscription s", Subscription.class)
				.getResultList();
	}
	
	@Override
	public List<Subscription> getSubscriptionsByStudent(Student student) {
		return em
				.createQuery("SELECT s from Subscription s where s.student=:x", Subscription.class)
				.setParameter("x", student)
				.getResultList();
	}
	
}
