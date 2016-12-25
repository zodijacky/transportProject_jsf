package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.Bus;
import pi.transport.persistance.Route;
import pi.transport.persistance.Trip;

@Remote
public interface RouteServiceRemote {
	Route create (Route route);
	Route find (Integer id);
	void update (Route route);
	void delete (Route route);
	void delete(Integer id );
	List<Route> findAll();
	List<Trip> findTripsByRoute(Route route);
	List<Route> findRoutesBySector(int idSector);
	List<Route> findRoutesNotInSector(int idSector) ;
	List<Route> findRoutesLike(String str) ;
	List<Route> findRoutesNotInSectorLike(String str);
	List<Route> findRoutesBySectorLike(int idSector, String str);
	List<Route> findRoutesByBus(Bus r);
	List<Route> findRoutesNotInBus(Bus r);
	List<Route> findRoutesByName(String name);
}
