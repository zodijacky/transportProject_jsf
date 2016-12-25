package pi.transport.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pi.transport.persistance.PrivateTransport;
import pi.transport.persistance.Taxi;


@Stateless
@LocalBean
public class TaxiService implements TaxiServiceRemote {

	@PersistenceContext
	private EntityManager em;
    public TaxiService() {
       
    }
	
	public void create(Taxi taxi) {
		em.persist(taxi);
		
	}
	
	public Taxi find(Integer numtaxi) {
		return em.find(Taxi.class, numtaxi);
		
	}
	
	public void update(Taxi taxi) {
		em.merge(taxi);
		
	}
	
	public void delete(Taxi taxi) {
		em.remove(em.merge(taxi));
		
	}
	
	public void delete(Integer numtaxi) {
		PrivateTransport taxi = em.find(PrivateTransport.class, numtaxi);
		em.remove(taxi);
		
	}
	
	public List<Taxi> findAll() {System.out.println("okok");
		return em.createQuery("select t from Taxi t",Taxi.class)
				.getResultList();
	}

	@Override
	public Taxi findByImmatriculation(String immatriculation) {
		
		return em.createQuery("select t from Taxi t where t.Immatriculation='"+immatriculation+"'", Taxi.class)
			.getSingleResult();
		
	}

}
