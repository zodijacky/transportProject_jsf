package pi.transport.services;

import pi.transport.persistance.*;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



/**
 * Session Bean implementation class DriverService
 */
@Stateless
@LocalBean
public class DriverService  implements DriverServiceRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;

	public DriverService() {}
    	

	@Override
	public void create(Driver driver) {
		em.persist(driver);
		
	}

	@Override
	public Driver find(Integer id) {
		return em.find(Driver.class, id);
		
	}

	@Override
	public void update(Driver driver) {
		em.merge(driver);
	}

	@Override
	public void delete(Driver driver) {
		em.remove(em.merge(driver));
		
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.find(Driver.class, id));
		
	}

	@Override
	public List<Driver> findAll() {
		 return em
				.createQuery("select d from Driver d", Driver.class)
				.getResultList();
		 
		 
	}

	@Override
	public Driver FindDriverByName(String name) {
		Driver driver=null;
		String jpql = "Select d from Driver d where d.lastName=:x";
		TypedQuery<Driver> query = em.createQuery(jpql, Driver.class);
		query.setParameter("x", name);
		driver=  query.getSingleResult();
		return driver;
	}


	

}
