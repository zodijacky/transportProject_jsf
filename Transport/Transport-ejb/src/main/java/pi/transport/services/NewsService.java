package pi.transport.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;

import pi.transport.persistance.News;

	/**
	 * Session Bean implementation class NewsService
	 */
	@Stateless
	@LocalBean
	public class NewsService implements NewsServiceRemote {
	@PersistenceContext
		EntityManager em;
	
		public NewsService() {
		
		}
	public void create(News news){		
			em.persist(news);	
		}
	
	public News find(Integer id) {
	
		return em.find(News.class, id); // ilfautajouter.class NB
	
	}
	public void delete(Integer id) {
	
		em.remove(em.find(News.class, id));
	}
	
	public void delete(News n) {
		
		em.remove(em.merge(n));
		
	}
	
	public List<News> findAll() {
		
		return em.createQuery("select d  from News d", News.class)
				.getResultList();
		
	}
	public void update(News n) {
	
		em.merge(n);
	}
	@Override
	public List<News> findNewsLike(String str) {
		return em
				.createQuery("select n  from News n where n.description like '%"+str+"%'",News.class)				
				.getResultList();
	
	}
	
		
	
	
	}
