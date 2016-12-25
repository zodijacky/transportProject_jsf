package pi.transport.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.transport.persistance.RailTransport;

/**
 * Session Bean implementation class RailTransportServices
 */
@Stateless
public class RailTransportService implements RailTransportServiceRemote {

	@PersistenceContext          
	private EntityManager em;
    
	
	public void add(RailTransport railtransport) {
		em.persist(railtransport);
		
	}
	
	

	
public RailTransport find(int id) {
		
		
		return em.find(RailTransport.class,id);
		
	}

	
	public void update(RailTransport rtransport) {
		em.merge(rtransport);
		
	}

	
	public void Delete(RailTransport rtransport) {
		
		em.remove(em.merge(rtransport));
		
		
	}
	
   

	
	public void Delete(Integer id) {
		
		em.remove(em.find(RailTransport.class,id));
		
	}

public void DeleteByImmatriculation(String nom) {
		
		em.remove(em.find(RailTransport.class,nom));
		
	}
	public List<RailTransport> findAll() {
		
		
	return em.createQuery("select rt from RailTransport rt", RailTransport.class).getResultList();
		
		
		
	}
	
	
	public List<RailTransport> findBySector() {
		
		
		return em.createQuery("select rt from RailTransport rt", RailTransport.class).getResultList();
			
			
			
		}
	
	public List<RailTransport> findAllBySector(int id) {
		return em.createQuery("select r  from RailTransport r where r.sector = "+id, RailTransport.class)
				.getResultList();
	}
	
public  List <RailTransport> findByImmatriculation(String immatriculation) {
		
		return em.createQuery("select rt from RailTransport rt where rt.immatriculation like '%"+immatriculation+"%'", RailTransport.class)
				.getResultList();
		
	}

public List<RailTransport> findByType(String type) {
	return em.createQuery("select rt from RailTransport rt where rt.type like '%"+type+"%'", RailTransport.class)
			.getResultList();
}

public long GStatistiques() {

    //Map<String, Integer> mapExp = new HashMap<String, Integer>();
	 long result = (long) em
             .createNativeQuery("select r.count(id) as nombre from RailTransport r", long.class)
             .getSingleResult();
	 
	//TypedQuery<RailTransport> query=em.createQuery("select r.count(id) as nombre from RailTransport r",RailTransport.class);
	//long result=query.getSingleResult();
	//int nbCorrectAnswers = (result).intValue(); // convertit result en Integer
	//v.setNumber(nbCorrectAnswers);
    System.out.println("hhhhhhh"+result);
	//v.setSector(sector);
	//evaluationRepository.save(v);	
	//return nbCorrectAnswers ;
    
    return result;
    }

}
