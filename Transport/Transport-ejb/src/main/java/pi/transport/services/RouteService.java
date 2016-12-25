package pi.transport.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.transport.persistance.Bus;
import pi.transport.persistance.Route;
import pi.transport.persistance.Sector;
import pi.transport.persistance.Trip;


@Stateless
@LocalBean
public class RouteService implements RouteServiceRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Route create(pi.transport.persistance.Route route) {	
		
		em.persist(route);		
		return (route);
	}

	@Override
	public Route find(Integer id) {
		return em.find(Route.class, id); // ilfautajouter.class NB
	}

	@Override
	public void update(pi.transport.persistance.Route route) {
		em.merge(route);
	}

	@Override
	public void delete(pi.transport.persistance.Route route) {
		em.remove(em.merge(route));
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.find(Route.class, id));
	}

	@Override
	public List<pi.transport.persistance.Route> findAll() {
		return em.createQuery("select r  from Route r", Route.class)
				.getResultList();
	}

	@Override
	public List<Trip> findTripsByRoute(pi.transport.persistance.Route route) {
		return em
				.createQuery("select t  from Trip t where t.route =:x  ",Trip.class)
				.setParameter("x", route)
				.getResultList();
	}
	@Override
	public List<Route> findRoutesBySector(int idSector) {
		return em
				.createQuery("select r  from Route r where sector =  "+idSector,Route.class)				
				.getResultList();	
	}
	@Override
	public List<Route> findRoutesBySectorLike(int idSector , String str) {
		return em
				.createQuery("select r  from Route r where sector =  "+idSector
						+" and r.name like '%"+str+"%'",Route.class)				
				.getResultList();	
	}
	
	@Override
	public List<Route> findRoutesNotInSector(int idSector) {
		return em
				.createQuery("select r  from Route r where sector is NULL ",Route.class)				
				.getResultList();
	}

	@Override
	public List<Route> findRoutesNotInSectorLike(String str) {
		return em
				.createQuery("select r  from Route r where sector is NULL and r.name like '%" +str+"%'",Route.class)				
				.getResultList();
	}
	
	@Override
	public List<Route> findRoutesLike(String str) {
		return em
				.createQuery("select r  from Route r where r.name like '%"+str+"%'",Route.class)				
				.getResultList();
	
	}
	
	@Override
	public List<Route> findRoutesByBus(Bus r) {	
		return em.createQuery("select d from Route d where :x Member of d.buses ", Route.class).setParameter("x", r)
			.getResultList();		
	}

	@Override
	public List<Route> findRoutesNotInBus(Bus r) {	
		return em.createQuery("select d from Route d where :x Not Member of d.buses ", Route.class).setParameter("x", r)
			.getResultList();		
	}

	@Override
	public List<Route> findRoutesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
