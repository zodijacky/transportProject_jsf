package pi.transport.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;




import pi.transport.persistance.Request;
import pi.transport.persistance.User;

/**
 * Session Bean implementation class RequestService
 */
@Stateless
@LocalBean
public class RequestService implements RequestServiceRemote {

	@PersistenceContext
	private EntityManager em;
    
	
    public RequestService() {
        
    }

	@Override
	public void create(Request request) {
		em.persist(request);
	}

	@Override
	public void update(Request request) {
		em.merge(request);
	}

	@Override
	public void delete(Request request) {
		em.remove(em.merge(request));
		
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.find(Request.class, id));
		
	}

	@Override
	public Request find(Integer id) {
		return em.find(Request.class, id);
	}

	@Override
	public List<Request> findAll() {
		return em
				.createQuery("select r from Request r  " , Request.class)
				.getResultList();
	}

	@Override
	public List<Request> findRequestByUser(User user) {
		return em
				.createQuery("select r from Request r where r.user=:x ", Request.class)
				.setParameter("x",user)
				.getResultList();
	}

     @Override
	 public List<Request> FindRequestLikeNameUser(String name)

	 {
    	 return em
    				.createQuery("select r  from Request r where r.user.firstName LIKE '"+name+"%'",Request.class)				
    				.getResultList();
	 }

	
}
