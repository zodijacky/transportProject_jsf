package pi.transport.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pi.transport.persistance.Sector;

/**
 * Session Bean implementation class SectorService
 */
@Stateless
@LocalBean
public class SectorService implements SectorServiceRemote {

    /**
     * Default constructor. 
     */
    public SectorService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
	
	@Override
	public Sector create(Sector sect) {
	em.persist(sect);
	return sect;
	}

	@Override
	public Sector find(Integer id) {
		return (em.find(Sector.class, id));
	}

	@Override
	public void update(Sector sect) {
		em.merge(sect);
	}

	@Override
	public void delete(Sector sect) {
		em.remove(em.merge(sect));
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.find(Sector.class, id));
	}

	@Override
	public List<Sector> findAll() {
		return em.createQuery("select s  from Sector s", Sector.class)
				.getResultList();
	}
	public List<Sector> findSectorsLike(String str) {
		return em.createQuery("select s  from Sector s where s.area like '%"+str+"%'", Sector.class)
				.getResultList();
	}
	public Sector findId(String area) {
		Sector found=null;
		TypedQuery<Sector> query=em.createQuery("select s from Sector s where s.area=:x",Sector.class);
			query.setParameter("x",area);
			try{
				found=query.getSingleResult();
			}
			catch(NoResultException e){
				System.out.println("no sector found with given login");
			}
		return found;
	}

}
