package pi.transport.services;

import java.util.List;
import javax.ejb.Remote;
import pi.transport.persistance.Trip;

@Remote
public interface TripServiceRemote {
	Trip create (Trip trip);
	Trip find (Integer id);
	void update (Trip trip);
	void delete (Trip trip);
	void delete(Integer id );
	List<Trip> findAll();
	List<Trip> findByRoute(int id);
	List<Trip> findTripsNotInRoute(int idRoute);
	List<Trip> findTripsLike(String str,String str1);
	List<Trip> findByRouteLike(int route, String str, String str1);
	List<Trip> findTripsNotInRouteLike(String str, String str1);
}
