package pi.transport.services;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.transport.persistance.Station;
import pi.transport.persistance.Trip;
import pi.transport.persistance.TripSchedule;

@Stateless
public class TripScheduleService implements TripschedulesServiceRemote{

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void add(TripSchedule tripSchedule) {
		em.persist(tripSchedule);
		
	}

	@Override
	public TripSchedule find(Integer id) {
		return em.find(TripSchedule.class, id);
		
	}

	@Override
	public void update(TripSchedule tripSchedule) {
		em.merge(tripSchedule);
		
	}

	@Override
	public void Delete(TripSchedule tripSchedule) {
		em.remove(em.merge(tripSchedule));
		
	}

	@Override
	public void Delete(Integer id) {
		TripSchedule ts = em.find(TripSchedule.class, id);
		
		em.remove(ts);		
	}

	@Override
	public List<TripSchedule> findAll() {
		return em.createQuery("select ts from Tripschedules ts", TripSchedule.class)
				.getResultList();
	}
	
	

	@Override
	public List<Trip> getTripsForTheseStations(Station dep, Station arr) {
		
		List<Trip> trips = new ArrayList<Trip>();
		Trip firstTrip = null;
		Trip lastTrip = null;
		
		firstTrip = em.createQuery("select t from Trip t WHERE t.id_dep = " + dep.getId(), Trip.class).getSingleResult();
		if(firstTrip != null)
		{
			trips.add(firstTrip);
			
			Trip t = firstTrip;
			
			while(lastTrip == null)
			{
				t = em.createQuery("select t from Trip t WHERE t.id_dep = " + t.getArrival().getId(), Trip.class).getSingleResult();
				
				trips.add(t);
				
				if(t.getArrival().getId() == arr.getId())
					lastTrip = t;
			}
		}
		
		else
		{
			firstTrip = em.createQuery("select t from Trip t WHERE t.id_arr = " + dep.getId(), Trip.class).getSingleResult();
			
			trips.add(firstTrip);
			
			Trip t = firstTrip;
			
			while(lastTrip == null)
			{
				t = em.createQuery("select t from Trip t WHERE t.id_arr = " + t.getDeparture().getId(), Trip.class).getSingleResult();
				
				trips.add(t);
				
				if(t.getDeparture().getId() == arr.getId())
					lastTrip = t;
			}
			
		}
				
		
		return trips;
	}
	
	

	@Override
	public TripSchedule getScheduleForThisTrip(Trip trip, Time time) {
		List<TripSchedule> Schedules = em.createQuery("select ts from Tripschedules ts WHERE id_trip = " + trip.getId() + " AND ts.depTime >= " + time, TripSchedule.class)
				.getResultList();
		
		TripSchedule closestScheduleTime = Schedules.get(0);
		for (TripSchedule ts : Schedules) {
			if(ts.getDepTime().before(closestScheduleTime.getDepTime()))
				closestScheduleTime = ts;
			}
		
		return closestScheduleTime;
		
	}

	@Override
	public List<TripSchedule> getScheduleForThisTrip(Trip trip) {
		return em.createQuery("select ts from Tripschedules ts WHERE id_trip = " + trip.getId(), TripSchedule.class)
		.getResultList();
	}
	
	

}
