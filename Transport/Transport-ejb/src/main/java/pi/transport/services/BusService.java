package pi.transport.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

import pi.transport.persistance.Bus;
import pi.transport.persistance.News;
import pi.transport.persistance.Route;

/**
 * Session Bean implementation class BusService
 */
@Stateless
@LocalBean
public class BusService implements BusServiceRemote {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public BusService() {
        // TODO Auto-generated constructor stub
    }
     public Bus create(Bus bus){
		
		em.persist(bus);
		return bus;
	}
public Bus find(Integer id) {

	return em.find(Bus.class, id); // ilfautajouter.class NB

}
	public void delete(Integer immat) {

		em.remove(em.find(Bus.class, immat));

	}
	public void delete(Bus b) {
		
		em.remove(em.merge(b));
		
	}
	@Override
	public List<Bus> findAll() {
		
		return em.createQuery("select d  from Bus d", Bus.class)
				.getResultList();
	}
	
	@Override
	public List<Bus> findBusesByRoute(Route r) {	
		return em.createQuery("select d from Bus d where :x Member of d.listRoute ", Bus.class).setParameter("x", r)
			.getResultList();		
	}
	@Override
	public List<Bus> findBusesNotInRoute(Route r) {	
		return em.createQuery("select d from Bus d where :x Not Member of d.listRoute ", Bus.class).setParameter("x", r)
			.getResultList();		
	}
	
	
	public void update(Bus b) {

		em.merge(b);
	}
	public List<Bus> findBussLike(String str) {
		return em
				.createQuery("select b  from Bus b where b.immatriculation like '%"+str+"%'",Bus.class)				
				.getResultList();
	
	}
	

}

	


