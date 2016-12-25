package pi.transport.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.transport.persistance.StationChief;


	@Stateless
	@LocalBean
	public class StationChiefService implements StationChiefServiceRemote {
	
	@PersistenceContext
		EntityManager em;

	@Override
	public void create(StationChief stationChief) {
		em.persist(stationChief);
		
	}

	@Override
	public void delete(StationChief stationChief) {
		em.remove(em.merge(stationChief));
		
	}

	@Override
	public void delete(Integer id) {
		StationChief chief = em.find(StationChief.class, id);
		
		em.remove(chief);
	}

	@Override
	public List<StationChief> findAll() {
		return em.createQuery("select sc from StationChief sc", StationChief.class)
				.getResultList();
	}

	@Override
	public void update(StationChief stationChief) {
		em.merge(stationChief);
		
	}

	@Override
	public StationChief find(Integer id) {
		return em.find(StationChief.class, id);
		
	}
	
	
	
	
	}
