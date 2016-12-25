package pi.transport.services;

import java.util.List;

import javax.ejb.Local;


import pi.transport.persistance.RouteSuggestion;
import pi.transport.persistance.Sector;

@Local
public interface RoutesSuggestionServiceLocal {

	
	
	RouteSuggestion createRoute(RouteSuggestion routeS);
	void saveRoute(RouteSuggestion routeS);
	void removeProduct(RouteSuggestion routeS);
	List<RouteSuggestion> findAllRoutesSuggestion();
	
	List<RouteSuggestion> findProductsByCategory(Sector sector);
	
	Sector findSectorByArea(String area);
	List<Sector> findAllSectors();
	
}
