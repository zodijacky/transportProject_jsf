package pi.transport.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import pi.transport.persistance.News;
import pi.transport.persistance.PublicTransport;
import pi.transport.persistance.Sector;

/**
 * Session Bean implementation class publicTransportServices
 */
@Stateless
public class PublicTransportService implements PublicTransportServiceRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext          
	private EntityManager em;
	
	public void add(PublicTransport publictransport) {
		em.persist(publictransport);
		
	}
	public void AsignSectorToPublicTrransport(PublicTransport publictransport) {
		Sector sector=new Sector(1,"sfdd");
		em.persist(sector);
		
	}
	
	
	
public PublicTransport find(Integer id) {
		
		
		return em.find(PublicTransport.class,id);
		
	}

	
	public void update(PublicTransport ptransport) {
		em.merge(ptransport);
		
	}

	
	public void Delete(PublicTransport ptransport) {
		
		em.remove(em.merge(ptransport));
		
		
	}

   

	public void Delete(Integer id) {
		
		em.remove(em.find(PublicTransport.class,id));
		
	}

	
	public List<PublicTransport> findAll() {
		
		
	return em.createQuery("select t from PublicTransport t", PublicTransport.class).getResultList();
		
		
		
	}
	
	public List<PublicTransport> findPublicTransportBySector(Sector sect) {
		
		
	Query query=(Query) em.createQuery("select distinct t.PublicTransport from sector t join t.type where t.sector=:sector");
	  ((TypedQuery<PublicTransport>) query).setParameter("sector",sect);
	return ((javax.persistence.Query) query).getResultList();
			
			
			
		}
	/*public List<News> findNewsByPublicTransport(PublicTransport pt) {
		// TODO Auto-generated method stub
		return em
				.createQuery("select n from News n where n.PublicTransport=:x", News.class)
				.setParameter("x", pt)
				.getResultList();
	}
	*/
	@Override
	public List<News> findNewsByPublicTransport(PublicTransport pt) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
