package pi.transport.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.transport.persistance.Transport;

/**
 * Session Bean implementation class TransportServices
 */
@Stateless
public class TransportService implements TransportServiceRemote {

	@PersistenceContext          
	private EntityManager em;
    
	
	public void add(Transport transport) {
		em.persist(transport);
		
	}
    public Transport find(Integer id) {
		
		
		return em.find(Transport.class,id);
		
	}

	
	public void update(Transport transport) {
		em.merge(transport);
		
	}

	
	public void Delete(Transport transport) {
		
		em.remove(em.merge(transport));
		
		
	}

	
	public void Delete(Integer id) {
		
		em.remove(em.find(Transport.class,id));
		
	}

	
	public List<Transport> findAll() {
		
		
	return em.createQuery("select t from Transport t", Transport.class).getResultList();
		
		
		
	}

}
