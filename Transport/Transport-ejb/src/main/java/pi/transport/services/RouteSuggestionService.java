package pi.transport.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pi.transport.persistance.RouteSuggestion;
import pi.transport.persistance.Sector;


@Stateless

public class RouteSuggestionService implements RoutesSuggestionsServiceRemote,RoutesSuggestionServiceLocal  {

    
	
	@PersistenceContext
	private EntityManager em;
    public RouteSuggestionService() {
       
    }

	
	public RouteSuggestion createRoute(RouteSuggestion routeS) {
		em.persist(routeS);
		return routeS;
	}

	
	public void saveRoute(RouteSuggestion routeS) {
		em.merge(routeS);
		
	}

	
	public void removeProduct(RouteSuggestion routeS) {
		em.remove(em.merge(routeS));
	}

	
	public List<RouteSuggestion> findAllRoutesSuggestion() {
		return em.createQuery("select r from RouteSuggestion r", RouteSuggestion.class)
				.getResultList();
	}

	
	public List<RouteSuggestion> findProductsByCategory(Sector sector) {
		return em
				.createQuery("select r from RouteSuggestion r where r.Sector=:s",
						RouteSuggestion.class).setParameter("s", sector)
				.getResultList();
	}


	
	public List<Sector> findAllSectors() {
		return em.createQuery("select s from Sector s", Sector.class)
				.getResultList();
	}


	
	public Sector findSectorByArea(String area) {
		Sector found = null;
		TypedQuery<Sector> query = em.createQuery(
				"select s from Sector s where s.area=:x", Sector.class);
		query.setParameter("x", area);
		try {
			found = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO,
					"no sector with area=" + area);
		}
		return found;
	}

	
}
