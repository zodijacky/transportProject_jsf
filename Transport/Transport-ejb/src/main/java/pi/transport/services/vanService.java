package pi.transport.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.transport.persistance.PrivateTransport;
import pi.transport.persistance.Van;


@Stateless
@LocalBean
public class vanService implements vanServiceRemote {

   
	 @PersistenceContext
		private EntityManager em;
    public vanService() {
       
    }

	
	public void create(Van van) {
		em.persist(van);
	}

	
	public Van find(Integer id) {
		 return em.find(Van.class, id);
	}

	
	public void update(Van van) {
		em.merge(van);
		
	}

	
	public void delete(Van van) {
		em.remove(em.merge(van));
		
	}

	
	public void delete(Integer id) {
	Van van = em.find(Van.class, id);
		em.remove(van);
		
		
	}

	
	public List<Van> findAll() {
		return em.createQuery("select v  from Van v",Van.class)
				.getResultList();
	}

}
