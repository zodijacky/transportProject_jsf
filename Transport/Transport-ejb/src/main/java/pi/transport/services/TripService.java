package pi.transport.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.transport.persistance.Route;
import pi.transport.persistance.Trip;

/**
 * Session Bean implementation class TripService
 */
@Stateless
@LocalBean
public class TripService implements TripServiceRemote {

    /**
     * Default constructor. 
     */
    public TripService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
	
	@Override
	public Trip create(Trip trip) {
		em.persist(trip);
		return trip;
	}

	@Override
	public Trip find(Integer id) {
		return em.find(Trip.class, id);
	}

	@Override
	public void update(Trip trip) {
		em.merge(trip);
	}

	@Override
	public void delete(Trip trip) {
		em.remove (em.merge(trip));
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.find(Trip.class, id));
	}

	@Override
	public List<Trip> findAll() {
		
		return em.createQuery("select t  from Trip t", Trip.class)
				.getResultList();
		
		
	}
	@Override
	public List<Trip> findByRoute(int route) {
		
    	return em
				.createQuery("select t  from Trip t where t.route ="+route,Trip.class)
				.getResultList();
		
	}
	@Override
	public List<Trip> findByRouteLike (int route,String str,String str1) {
		
    	return em
				.createQuery("select t  from Trip t where t.route ="+route
	+" and t.arrival like '%"+str1+"%' and t.departure like '%"+str+"%'"
						,Trip.class)
				.getResultList();
		
	}
	
    @Override
	public List<Trip> findTripsNotInRoute(int idRoute) {
		return em
				.createQuery("select t from Trip t where route is NULL ",Trip.class)				
				.getResultList();	
	}
    
    
    @Override
   	public List<Trip> findTripsNotInRouteLike(String str,String str1) {
    	return em
				.createQuery("select t  from Trip t where t.route is NULL "
	+" and t.arrival like '%"+str1+"%' and t.departure like '%"+str+"%'"
						,Trip.class)
				.getResultList();
		
   	}
    
    
    @Override	
	public List<Trip> findTripsLike(String str,String str1) {
		return em
				.createQuery("select t from Trip t where t.arrival like '%"+str1+"%' and t.departure like '%"+str+"%'",Trip.class)				
				.getResultList();
	
	}

}
