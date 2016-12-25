package pi.transport.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.transport.persistance.Station;

@Stateless
public class StationService implements StationServiceRemote{

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void add(Station station) {
		em.persist(station);
		
	}

	@Override
	public Station find(Integer id) {
		return em.find(Station.class, id);
		
	}

	@Override
	public void update(Station station) {
		em.merge(station);
		
	}

	@Override
	public void Delete(Station station) {
		em.remove(em.merge(station));
		
	}

	@Override
	public void Delete(Integer id) {
		Station station = em.find(Station.class, id);
		
		em.remove(station);		
	}

	@Override
	public List<Station> findAll() {
		return em.createQuery("select s from Station s", Station.class)
				.getResultList();
	}

}
