//package pi.transport.services;
//
//import java.util.List;
//
//import javax.ejb.LocalBean;
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import pi.transport.persistance.BusRoute;
//import pi.transport.persistance.News;
///**
// * Session Bean implementation class BusRouteService
// */
//@Stateless
//@LocalBean
//public class BusRouteService implements BusRouteSeviceRemote {
//	@PersistenceContext
//	private EntityManager em;
//    public BusRouteService() {
//      
//    }
//
//
//public void create(BusRoute busRoute){
//		
//		em.persist(busRoute);
//		
//	}
//public BusRoute find(Integer id) {
//
//	return em.find(BusRoute.class, id); // ilfautajouter.class NB
//
//}
//
//	public void delete(Integer idBusRoute) {
//
//		em.remove(em.find(BusRoute.class, idBusRoute));
//
//	}
//	
//	public void delete(BusRoute busRoute) {
//		em.remove(em.merge(busRoute));
//			}
//	
//	public List<BusRoute> findAll() {
//		
//		return em.createQuery("select d  from BusRoute d", BusRoute.class)
//				.getResultList();
//	}
//	
//	public void update(BusRoute busRoute) {
//
//		em.merge(busRoute);
//	}
//
//	
//
//
//}
