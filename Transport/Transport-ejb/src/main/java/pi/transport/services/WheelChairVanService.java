package pi.transport.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.transport.persistance.Van;
import pi.transport.persistance.WheelChairVan;


@Stateless
@LocalBean
public class WheelChairVanService implements WheelChairVanServiceRemote {

	@PersistenceContext
	private EntityManager em;
    public WheelChairVanService() {
       
    }

	
	public void create(WheelChairVan wcvan) {
		em.persist(wcvan);
		
	}

	
	public WheelChairVan find(Integer id) {
		 return em.find(WheelChairVan.class, id);
			}
	

	
	public void update(WheelChairVan wcvan) {
	
		em.merge(wcvan);	
	}

	
	public void delete(WheelChairVan wcvan) {
		em.remove(em.merge(wcvan));
	}

	
	public void delete(Integer id) {
		WheelChairVan wcvan = em.find(WheelChairVan.class, id);
		em.remove(wcvan);
		
		
	}

	
	public List<WheelChairVan> findAll() {
		return em.createQuery("select w  from WheelChairVan w", WheelChairVan.class)
				.getResultList();
	}

}
