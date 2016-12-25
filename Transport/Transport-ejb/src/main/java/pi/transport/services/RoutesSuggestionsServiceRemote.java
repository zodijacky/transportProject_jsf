package pi.transport.services;

import java.util.List;

import javax.ejb.Remote;

import pi.transport.persistance.RouteSuggestion;
import pi.transport.persistance.Sector;
@Remote 
public interface RoutesSuggestionsServiceRemote {

	
	
	RouteSuggestion createRoute(RouteSuggestion routeS);
	void saveRoute(RouteSuggestion routeS);
	void removeProduct(RouteSuggestion routeS);
	List<RouteSuggestion> findAllRoutesSuggestion();
	
	List<RouteSuggestion> findProductsByCategory(Sector sector);
	
	
	List<Sector> findAllSectors();
}
