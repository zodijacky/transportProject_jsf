package pi.transport.services;

import java.sql.Time;
import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Station;
import pi.transport.persistance.Trip;
import pi.transport.persistance.TripSchedule;;

@Remote
public interface TripschedulesServiceRemote {

	void add(TripSchedule tripSchedule);
	TripSchedule find(Integer id);
	void update(TripSchedule tripSchedule);
	void Delete (TripSchedule tripSchedule);
	void Delete(Integer id);
	List<TripSchedule> findAll();
	
	List<Trip> getTripsForTheseStations(Station dep, Station arr);
	
	List<TripSchedule> getScheduleForThisTrip(Trip trip);
	
	TripSchedule getScheduleForThisTrip(Trip trip, Time time);
}
