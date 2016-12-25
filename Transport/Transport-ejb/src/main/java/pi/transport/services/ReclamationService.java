package pi.transport.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.transport.persistance.Reclamation;
import pi.transport.persistance.User;

/**
 * Session Bean implementation class ReclamationServices
 */
@Stateless
public class ReclamationService implements ReclamationServiceRemote {

	@PersistenceContext          
	private EntityManager em;
	
	
	public void add(Reclamation reclamation) {
		// TODO Auto-generated method stub
		em.persist( reclamation);
		
	}
	
	
	public Boolean addReclamation(Reclamation reclamation) {
		Boolean b = false;
		try {
			em.persist(reclamation);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}
public Reclamation find(Integer id) {
		
		
		return em.find(Reclamation.class,id);
		
	}

	
	public void update(Reclamation  reclamation) {
		em.merge(reclamation);
		
	}

	
	public void Delete(Reclamation reclamation) {
		
		em.remove(em.merge(reclamation));	
	}

	
	public void Delete(Integer id) {
		em.remove(em.find(Reclamation.class,id));
	}

	
	public List<Reclamation>findAll() {
		
		
	return em.createQuery("select rc from t_reclamation rc", Reclamation.class).getResultList();
		
		
	}

	

	

	

	
	
}
